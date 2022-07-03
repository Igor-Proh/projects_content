package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Components;
import com.prokhnov.projectcontent.service.ProjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "components")
public class ComponentController {

    private ProjectServiceImpl projectServiceImpl;

    @RequestMapping(value = "/list/{id}")
    public String showComponents(Model model, @PathVariable String id){

        int ids = Integer.parseInt(id);
        List<Components> listOfProjectComponents = projectServiceImpl.getProjectById(ids).getProjectComponent();
        model.addAttribute("components", listOfProjectComponents);
        return "all-project-components-page";
    }
}
