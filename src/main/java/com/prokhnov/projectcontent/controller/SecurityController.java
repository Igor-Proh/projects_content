package com.prokhnov.projectcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/showLoginPage")
    public String showLoggingPage(){
        return "login-page";
    }
}
