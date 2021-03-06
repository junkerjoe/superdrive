package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {

    private UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignup(@ModelAttribute Users users, Model model) {
        model.addAttribute(users);
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute Users users, Model model) {
        String errorMessage = null;
        if (!userService.isUsernameAvailable(users.getUsername())) {
            errorMessage = "This user already exists!";
        }
        if (errorMessage == null) {
            int rowsAdded = userService.createUser(users);
            if (rowsAdded < 0) {
                errorMessage = "There was an error signing you up. Please try again.";
            }
        }
        if (errorMessage == null) {
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", true);
            model.addAttribute("errorMsg", errorMessage);
        }
        return "signup";
    }
}
