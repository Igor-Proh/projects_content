package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.service.ProjectService;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    @Autowired
    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @RequestMapping(value = "/allProjects")
    public String showAllProjects(Model model) {

        List<Project> allProjects = projectServiceImpl.getAllProjects();
        model.addAttribute("projects", allProjects);

        return "all-projects-page";
    }

}
