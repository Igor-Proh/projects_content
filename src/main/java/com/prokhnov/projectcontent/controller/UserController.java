package com.prokhnov.projectcontent.controller;

import com.prokhnov.projectcontent.repository.RoleRepository;
import com.prokhnov.projectcontent.model.Role;
import com.prokhnov.projectcontent.model.User;
import com.prokhnov.projectcontent.service.UserService;
import com.prokhnov.projectcontent.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;
    private final UserService userServiceImpl;
    private final UserValidator userValidator;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService, UserService userServiceImpl, UserValidator userValidator, RoleRepository roleRepository) {
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
        this.userValidator = userValidator;
        this.roleRepository = roleRepository;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String userRegistration(Model model) {
        User user = new User();
        model.addAttribute("userForm", user);
        return "registration-page";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration-page";
        }
        redirectAttributes.addFlashAttribute("user", userForm);
        return "redirect:/user/saveUser";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String homePage() {
        return "welcome-page";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("user", users);
        return "all-users-page";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-page";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userId") long id) {
        userService.getUserById(id).setRoles(new HashSet<>());
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user, Model model) {

        if (user.getUserId() != 0) {
            user.setRoles(userService.getUserById(user.getUserId()).getRoles());
        } else {
            List<Role> roles = roleRepository.findAll();
            for (Role role : roles) {
                if (role.getRoleName().equals("USER")) {
                    user.getRoles().add(role);
                }
            }
            user.setUserEnabled(true);
        }

        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userId", user.getUserId());
        userServiceImpl.saveUser(user);
        return "redirect:/user/welcome";
    }

}
