package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rikabc.form.NoteForm;
import ru.rikabc.models.Note;
import ru.rikabc.services.NotesService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    NotesService service;

    @GetMapping
    public List<Note> getAllNotes(HttpServletRequest request) {
        return service.getAllNotes(request);
    }

    @PostMapping
    public ResponseEntity<Object> createNote(HttpServletRequest request, @RequestBody NoteForm note) {
        return service.createNote(request, note);
    }

    @GetMapping("/{fileId}")
    public Note getNote(HttpServletRequest request) {
        return service.getNote(request);
    }

    @PutMapping("/{fileId}")
    public ResponseEntity<Object> updateNote(@PathVariable Long fileId,
                                             @RequestBody NoteForm note, HttpServletRequest request) {
        return service.updateNote(fileId, note, request);
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<String> deleteNote(@PathVariable Long fileId) {
        return service.deleteNote(fileId);
    }
}
