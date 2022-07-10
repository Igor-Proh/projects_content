package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Components;
import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.entity.User;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import com.prokhnov.projectcontent.validator.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;
    private final ProjectValidator projectValidator;

    @Autowired
    public ProjectController(ProjectServiceImpl projectServiceImpl, ProjectValidator projectValidator) {
        this.projectServiceImpl = projectServiceImpl;
        this.projectValidator = projectValidator;
    }

    @RequestMapping(value = {"/list/{id}", "{id}", "/list/sort/{id}"}, method = RequestMethod.GET)
    public String showComponents(Model model, @PathVariable String id) {
        int ids = Integer.parseInt(id);
        List<Components> listOfProjectComponents = projectServiceImpl.getProjectById(ids).getProjectComponent();
        model.addAttribute("components", listOfProjectComponents);
        model.addAttribute("id", id);
        model.addAttribute("nameOfProject", projectServiceImpl.getProjectById(ids).getProjectName());
        return "all-project-components-page";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllProjects(Model model) {
        List<Project> allProjects = projectServiceImpl.getAllProjects();
        model.addAttribute("projects", allProjects);
        return "all-projects-page";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject(Model model) {
        Project project = new Project();
        project.setProjectDateOfCreate(new Date());
        model.addAttribute("project", project);
        return "project-page";
    }
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
       projectValidator.validate(project,bindingResult);

        if (bindingResult.hasErrors()) {
            return "project-page";
        }
        redirectAttributes.addFlashAttribute("project", project);
        return "redirect:/project/saveProject";

    }

    @RequestMapping(value = "/saveProject")
    public String saveProject(@ModelAttribute("project") Project project) {

        if (project.getProjectId() != 0) {
            project.addListOfComponents(projectServiceImpl
                    .getProjectById(project.getProjectId()).getProjectComponent());
        }

        project.setProjectDateOfCreate(new Date());
        projectServiceImpl.saveProject(project);

        return "redirect:/project/list";
    }

    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(@RequestParam("projectId") long projectId, Model model) {
        Project project = projectServiceImpl.getProjectById(projectId);
        model.addAttribute("project", project);
        return "project-page";
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
    public String deleteProject(@RequestParam("projectId") long id) {
        projectServiceImpl.deleteProjectById(id);
        return "redirect:/project/list";
    }

    @RequestMapping(value = "/list/sort", method = RequestMethod.GET)
    public String sortList(Model model, HttpServletRequest request) {
        List<Project> sortList = projectServiceImpl.getAllProjectsAndSortBy(request.getParameter("dropdown"));
        model.addAttribute("projects", sortList);
        return "all-projects-page";
    }

}
