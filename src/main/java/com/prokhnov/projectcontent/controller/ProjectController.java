package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Components;
import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    @Autowired
    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @RequestMapping({"/list/{id}", "{id}"})
    public String showComponents(Model model, @PathVariable String id) {
        int ids = Integer.parseInt(id);
        List<Components> listOfProjectComponents = projectServiceImpl.getProjectById(ids).getProjectComponent();
        model.addAttribute("components", listOfProjectComponents);
        model.addAttribute("id", id);
        model.addAttribute("nameOfProject", projectServiceImpl.getProjectById(ids).getProjectName());
        return "all-project-components-page";
    }

    @RequestMapping(value = "/list")
    public String showAllProjects(Model model) {
        List<Project> allProjects = projectServiceImpl.getAllProjects();
        model.addAttribute("projects", allProjects);
        return "all-projects-page";
    }

    @RequestMapping(value = "/addProject")
    public String showFormForAdd(Model model) {
        Project project = new Project();
        project.setProjectDateOfCreate(new Date());
        model.addAttribute("project", project);
        return "project-page";
    }

    @RequestMapping(value = "/saveProject")
    public String saveProject(@ModelAttribute("project") Project project) {

        if (project.getProjectId() != 0) {
            project.addListOfComponents(projectServiceImpl.getProjectById(project.getProjectId()).getProjectComponent());
        }

        projectServiceImpl.saveProject(project);
        return "redirect:/project/list";
    }

    @RequestMapping(value = "/updateProject")
    public String updateProject(@RequestParam("projectId") long projectId, Model model) {
        Project project = projectServiceImpl.getProjectById(projectId);

        model.addAttribute("project", project);
        return "project-page";
    }

    @RequestMapping(value = "/deleteProject")
    public String deleteProject(@RequestParam("projectId") long id) {
        projectServiceImpl.deleteProjectById(id);
        return "redirect:/project/list";
    }

}
