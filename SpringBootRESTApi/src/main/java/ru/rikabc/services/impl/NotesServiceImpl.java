package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.rikabc.form.NoteForm;
import ru.rikabc.models.Note;
import ru.rikabc.models.enums.Priority;
import ru.rikabc.repositories.NoteRepository;
import ru.rikabc.services.NotesService;
import ru.rikabc.utility.UserInputValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    NoteRepository repository;

    @Override
    public List<Note> getAllNotes(HttpServletRequest request) {
        return repository.findAll((Long) request.getAttribute("userId"));
    }

    @Override
    public Note getNote(HttpServletRequest request) {
        return (Note) request.getAttribute("note");
    }

    @Override
    public ResponseEntity<Object> createNote(HttpServletRequest request, NoteForm note) {
        String result = UserInputValidator.validNote(note);

        if (result.equals("ok")) {
            Note candidateNote = createNoteCandidate(request, note);
            candidateNote = repository.saveNote(candidateNote);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/notes/" + candidateNote.getNoteId());
            return new ResponseEntity<>(candidateNote, headers, CREATED);
        }
        return ResponseEntity.status(400).body(result);
    }

    @Override
    public ResponseEntity<Object> updateNote(Long fileId, NoteForm note, HttpServletRequest request) {
        String result = UserInputValidator.validNote(note);

        if (result.equals("ok")) {
            Note candidateNote = createNoteCandidate(request, note);
            candidateNote.setNoteId(fileId);
            candidateNote = repository.saveNote(candidateNote);
            return ResponseEntity.status(200).body(candidateNote);
        }
        return ResponseEntity.status(400).body(result);
    }

    @Override
    public ResponseEntity<String> deleteNote(Long fileId) {
        if (repository.delete(fileId))
            return ResponseEntity.ok("ok");
        return ResponseEntity.status(404).body("i don't know what happened");
    }


    private Note createNoteCandidate(HttpServletRequest request, NoteForm note) {
        Note candidateNote = new Note();
        candidateNote.setNote(note.getNote());
        candidateNote.setHeader(note.getHeader());
        candidateNote.setPriority(Priority.valueOf(note.getPriority()));
        candidateNote.setCreateDate(Date.valueOf(LocalDate.now()));
        candidateNote.setUserId((Long) request.getAttribute("userId"));
        return candidateNote;
    }
}
