package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.Users;
import com.prokhnov.projectcontent.service.UsersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UsersController {

    private final UsersServiceImpl userServiceImpl;

    public UsersController(UsersServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/list")
    public String getAllUsers(Model model) {

        List<Users> usersList = userServiceImpl.getAllUsers();
        model.addAttribute("users", usersList);
        return "all-users-page";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") Users user) {
        userServiceImpl.saveUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestParam("userId") long id, Model model) {
        Users user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") long id) {
        userServiceImpl.deleteUserById(id);
        return "redirect:/user/list";
    }


}
