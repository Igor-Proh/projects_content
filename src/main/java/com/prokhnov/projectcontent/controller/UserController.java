package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.User;
import com.prokhnov.projectcontent.service.UserService;
import com.prokhnov.projectcontent.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private UserValidator userValidator;


    @GetMapping(value = "/registration")
    public String userRegistration(Model model) {
        User user = new User();
//        user.userAddRole("USER");
//        user.setUserEnabled(true);

        model.addAttribute("userForm", user);
        return "registration-page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
//        if (bindingResult.hasErrors()) {

//            System.out.println(bindingResult.hasErrors());

//            return "registration-page";
//        }

        userService.saveUser(userForm);
        return "redirect:/";
    }

    @GetMapping(value = "/login")
    public String userLogin (Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "custom-page";
    }


    @GetMapping(value = "/")
    public String homePage(Model model) {
        return "welcome-page";
    }

    @RequestMapping(value ="/list")
    public String getAllUsers(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("user",users);
        return "all-users-page";
    }

        @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }
    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/user/list";
    }

}
