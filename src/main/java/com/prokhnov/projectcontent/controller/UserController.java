package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.User;
import com.prokhnov.projectcontent.service.UserService;
import com.prokhnov.projectcontent.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/list")
    public String getAllUsers(Model model){

        List<User> usersList = userServiceImpl.getAllUsers();
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
        userServiceImpl.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateProject(@RequestParam("userId") long id, Model model) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteProject(@RequestParam("userId") long id){
        userServiceImpl.deleteUserById(id);
        return "redirect:/user/list";
    }




}
