package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rikabc.models.User;
import ru.rikabc.services.SignUpService;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/signUp")
public class SignUpController {
    @Autowired
    SignUpService service;

    @GetMapping
    public String getSignUp() {
        return "signUp";
    }

    @PostMapping
    public String postSignUp(User user, RedirectAttributes redirectAttributes) {
        if (service.signUpNewUser(user)) {
            return "redirect:/profile";
        } else {
            redirectAttributes.addFlashAttribute("message"
                    , "user with the same username already exist");
            return "redirect:/signUp";
        }
    }
}
