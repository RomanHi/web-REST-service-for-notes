package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rikabc.services.NoteService;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/delete/{fileId}")
public class DeleteController {
    @Autowired
    NoteService service;

    @GetMapping
    public String getDelete(@PathVariable Long fileId) {
        service.delete(fileId);
        return "redirect:/profile";
    }
}
