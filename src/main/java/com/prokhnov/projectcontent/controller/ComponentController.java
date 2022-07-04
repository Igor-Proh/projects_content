package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Components;
import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.service.ComponentsServiceImpl;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/addComponent")
    public String showFormForAdd(@RequestParam("projectId") long projectId, Model model) {
        Components components = new Components();
        model.addAttribute("component", components);
        String id = String.valueOf(projectId);
        model.addAttribute("projectId", id);
        return "component-page";
    }

    @RequestMapping(value = "/saveComponent/{projectId}")
    public String saveComponent(@PathVariable long projectId, @ModelAttribute("component") Components components) {


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

        String id = String.valueOf(projectId);
        return "redirect:/project/list/" + id;
    }

    @RequestMapping(value = "/updateComponent")
    public String updateComponent(@RequestParam("componentId") long componentId, @RequestParam("projectId") String projectId, Model model) {
        Components components = componentsServiceImpl.getComponentsById(componentId);
        model.addAttribute("component", components);
        model.addAttribute("projectId", projectId);
        return "component-page";
    }

    @RequestMapping(value = "/deleteComponent")
    public String deleteComponent(@RequestParam("componentId") long componentId, @RequestParam("projectId") String projectId) {
        componentsServiceImpl.deleteComponentsById(componentId);
        return "redirect:/project/list/" + projectId;
    }
}
