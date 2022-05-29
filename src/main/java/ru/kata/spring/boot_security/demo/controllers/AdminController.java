package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.ArrayList;

@Controller

public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", userService.getAll());
        return "/admin";
    }

    @GetMapping("/user-create")
    public String createUserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles", required = false) String roles) {
        user.setUserRoles(roleService.getRoleByName(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deletedById(id);
        return "redirect:/admin";
    }


    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam(value = "nameRoles", required = false) String roles) {
        user.setUserRoles(roleService.getRoleByName(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }
}
