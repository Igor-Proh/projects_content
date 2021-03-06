package com.prokhnov.projectcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/hello"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "home-page";

    }

    @RequestMapping(value = ("/login"), method = RequestMethod.GET)
    public String login() {
        return "login-page";
    }
}
