package com.prokhnov.projectcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String login(){
        return "login-page";
    }
}
