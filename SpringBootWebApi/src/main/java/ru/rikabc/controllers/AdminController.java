package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rikabc.form.UserForm;
import ru.rikabc.models.User;
import ru.rikabc.services.AdminService;

import java.util.List;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping
    public String getAdminView(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping
    public String changeUser(UserForm user) {
        service.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("{id}")
    public String changeUser(@PathVariable Long id, Model model) {
        User user = service.findCurrentUser(id);
        model.addAttribute("user", user);
        return "changeUser";
    }
}
