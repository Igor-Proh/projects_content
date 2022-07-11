package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.model.Components;
import com.prokhnov.projectcontent.model.Project;
import com.prokhnov.projectcontent.service.ComponentsServiceImpl;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "components")
public class ComponentController {

    private final ComponentsServiceImpl componentsServiceImpl;
    private final ProjectServiceImpl projectServiceImpl;

    @Autowired
    public ComponentController(ComponentsServiceImpl componentsServiceImpl, ProjectServiceImpl projectServiceImpl) {
        this.componentsServiceImpl = componentsServiceImpl;
        this.projectServiceImpl = projectServiceImpl;
    }

    @RequestMapping(value = "/addComponent", method = RequestMethod.GET)
    public String addComponent(@RequestParam("projectId") long projectId, Model model) {
        Components components = new Components();
        model.addAttribute("component", components);
        String id = String.valueOf(projectId);
        model.addAttribute("projectId", id);
        return "component-page";
    }
    
    @RequestMapping(value = "/sort/{id}", method = RequestMethod.GET)
    public String sortBy(@PathVariable long id, HttpServletRequest request, Model model){
        List<Components> sortListOfProjectComponents =projectServiceImpl.getAllComponentsAndSortBy(id,request.getParameter("dropdown"));
        model.addAttribute("components",sortListOfProjectComponents);
        model.addAttribute("id", id);
        model.addAttribute("nameOfProject", projectServiceImpl.getProjectById(id).getProjectName());
        return "all-project-components-page";
    }

    @RequestMapping(value = "/saveComponent/{projectId}", method = RequestMethod.POST)
    public String saveComponent(@PathVariable long projectId, @ModelAttribute("component") Components components) {

        components.setComponentDateOfCreate(new Date());

        boolean flag = false;
        List<Components> list = projectServiceImpl.getProjectById(projectId).getProjectComponent();

        for (Components c : list) {
            if (components.getComponentId() == c.getComponentId()) {
                flag = true;
                break;
            }
        }

        if (flag) {
            componentsServiceImpl.saveComponents(components);
        } else {
            Project project = projectServiceImpl.getProjectById(projectId);
            project.addComponents(components);
            projectServiceImpl.saveProject(project);
        }

        return "redirect:/project/list/" + projectId;
    }

    @RequestMapping(value = "/updateComponent", method = RequestMethod.GET)
    public String updateComponent(@RequestParam("componentId") long componentId, @RequestParam("projectId") String projectId, Model model) {
        Components components = componentsServiceImpl.getComponentsById(componentId);
        model.addAttribute("component", components);
        model.addAttribute("projectId", projectId);
        return "component-page";
    }

    @RequestMapping(value = "/deleteComponent", method = RequestMethod.GET)
    public String deleteComponent(@RequestParam("componentId") long componentId, @RequestParam("projectId") String projectId) {
        componentsServiceImpl.deleteComponentsById(componentId);
        return "redirect:/project/list/" + projectId;
    }
}
