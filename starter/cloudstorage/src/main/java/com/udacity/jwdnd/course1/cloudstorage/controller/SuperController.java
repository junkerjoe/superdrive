package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
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
    public String getLogin(@ModelAttribute Users users, Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute Users users, Model model) {
        if (userService.getUser(users.username) != null) {
            return "home";
        }
        return "login";
    }

    @GetMapping("/signup")
    public String getSignup(@ModelAttribute Users users, Model model) {
        model.addAttribute(users);
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute Users users, Model model) {
        userService.createUser(users);
        //model.addAttribute(attributeName, userService.getUser(username))
        return "signup";
    }
}
