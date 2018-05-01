package ru.rikabc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rikabc.models.Note;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping
    public String getCurrentFile() {
        return "file";
    }

    @GetMapping("/{fileId}")
    public String getFile(HttpServletRequest request, RedirectAttributes attributes) {
        Note note = (Note) request.getAttribute("note");
        attributes.addFlashAttribute("note", note);
        return "redirect:/file";
    }
}
