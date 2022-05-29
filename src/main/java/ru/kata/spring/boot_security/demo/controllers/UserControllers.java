package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class UserControllers {

    private final UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPAge(Principal principal, Model model) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "/user";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/logout";
    }

}
