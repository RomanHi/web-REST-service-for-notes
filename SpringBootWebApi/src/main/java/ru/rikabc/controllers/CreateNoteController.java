package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rikabc.form.NoteForm;
import ru.rikabc.security.details.UserDetailsImpl;
import ru.rikabc.services.NoteService;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/create")
public class CreateNoteController {
    @Autowired
    NoteService service;

    @GetMapping
    public String getCreateNote() {
        return "createNote";
    }

    @PostMapping
    public String postCreateNote(@AuthenticationPrincipal UserDetailsImpl details,
                                 NoteForm note, RedirectAttributes attributes) {
        note.setUserId(details.getId());
        if (service.save(note)) {
            attributes.addFlashAttribute("message", "has been successfully added");
            return "redirect:/create";
        } else {
            attributes.addFlashAttribute("message", "something wrong");
            return "redirect:/create";
        }
    }
}
