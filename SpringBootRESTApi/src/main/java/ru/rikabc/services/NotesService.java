package ru.rikabc.services;

import org.springframework.http.ResponseEntity;
import ru.rikabc.form.NoteForm;
import ru.rikabc.models.Note;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public interface NotesService {
    List<Note> getAllNotes(HttpServletRequest request);

    Note getNote(HttpServletRequest request);

    ResponseEntity<Object> createNote(HttpServletRequest request, NoteForm note);

    ResponseEntity<Object> updateNote(Long fileId, NoteForm note, HttpServletRequest request);

    ResponseEntity<String> deleteNote(Long fileId);
}
