package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/list")
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
        projectServiceImpl.saveProject(project);
        return "redirect:/project/list";
    }

    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(@RequestParam("projectId") long id, Model model) {
        Project project = projectServiceImpl.getProjectById(id);
        model.addAttribute("project", project);
        return "project-page";
    }

    @RequestMapping(value = "/deleteProject")
    public String deleteProject(@RequestParam("projectId") long id){
        projectServiceImpl.deleteProjectById(id);
        return "redirect:/project/list";
    }

}
