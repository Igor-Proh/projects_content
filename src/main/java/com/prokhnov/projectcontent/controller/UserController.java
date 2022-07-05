package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.entity.User;
import com.prokhnov.projectcontent.service.UserService;
import com.prokhnov.projectcontent.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String userRegistration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration-page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration-page";
        }

        userService.saveUser(userForm);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login-page";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "welcome-page";
    }


//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public String getAllUsers(Model model) {
//
//        List<User> userList = userServiceImpl.getAllUsers();
//        model.addAttribute("users", userList);
//        return "all-users-page";
//    }
//
//    @RequestMapping(value = "/addUser")
//    public String addUser(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "user-page";
//    }
//
//    @RequestMapping(value = "/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userServiceImpl.saveUser(user);
//        return "redirect:/user/list";
//    }
//
//    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
//    public String updateUser(@RequestParam("userId") long id, Model model) {
//        User user = userServiceImpl.getUserById(id);
//        model.addAttribute("user", user);
//        return "user-page";
//    }
//
//    @RequestMapping(value = "/deleteUser")
//    public String deleteUser(@RequestParam("userId") long id) {
//        userServiceImpl.deleteUserById(id);
//        return "redirect:/user/list";
//    }


}
