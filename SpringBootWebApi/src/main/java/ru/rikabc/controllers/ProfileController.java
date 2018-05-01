package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rikabc.models.Note;
import ru.rikabc.security.details.UserDetailsImpl;
import ru.rikabc.services.ProfileService;

import java.util.List;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService service;

    @GetMapping
    public String getProfile(Model model,
                             @AuthenticationPrincipal UserDetailsImpl details) {
        long id = details.getId();
        List<Note> notes = service.getAllNotes(id);
        model.addAttribute("notes", notes);
        return "profile";
    }
}
