package com.prokhnov.projectcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping({"/", "/hello"})
    public String showHomePage() {
        return "home-page";

    }

    @RequestMapping("/ololo")
    public String a(){
        return "custom-page";
    }
}
