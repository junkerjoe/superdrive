package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuperController {

    private UserService userService;

    public SuperController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(@ModelAttribute("existingUser") User user, Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("existingUser") User user, Model model) {
        if (userService.getUser(user.username) != null) {
            return "home";
        }
        return "login";
    }

    @GetMapping("/signup")
    public String getSignup(@ModelAttribute("newUser") User user, Model model) {
        model.addAttribute(user);
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute("newUser") User user, Model model) {
        userService.createUser(user);
        //model.addAttribute(attributeName, userService.getUser(username))
        return "login";
    }
}
