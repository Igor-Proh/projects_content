package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Project;
import com.prokhnov.projectcontent.entity.User;
import com.prokhnov.projectcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list")
    public String getAllUsers(Model model){

        List<User> usersList = userService.getAllUsers();
        model.addAttribute("users", usersList);
        return "all-users-page";
    }


    @RequestMapping(value = "/addUser")
    public String showFormForUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/saveUser")
    public String saveProject(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateProject(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteProject(@RequestParam("userId") long id){
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }




}
