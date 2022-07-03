package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.service.ComponentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "components")
public class ComponentController {

    private final ComponentsServiceImpl componentsServiceImpl;

    @Autowired
    public ComponentController(ComponentsServiceImpl componentsServiceImpl) {
        this.componentsServiceImpl = componentsServiceImpl;
    }



    @RequestMapping(value = "/deleteComponent")
    public String deleteComponent(@RequestParam("componentId") long componentId, @RequestParam("projectId") String projectId) {
        componentsServiceImpl.deleteComponentsById(componentId);
        return "redirect:/project/list/" + projectId;
    }
}
