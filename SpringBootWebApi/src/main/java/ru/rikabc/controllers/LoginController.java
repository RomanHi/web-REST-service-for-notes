package ru.rikabc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String getLogin(HttpServletRequest request, Model model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("message", "invalid username or password.");
        }
        if (request.getParameterMap().containsKey("logout")) {
            model.addAttribute("message", "you have been successful logout");
        }
        return "login";
    }
}
