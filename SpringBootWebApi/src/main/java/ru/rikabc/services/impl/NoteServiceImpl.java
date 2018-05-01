package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rikabc.form.NoteForm;
import ru.rikabc.models.Note;
import ru.rikabc.models.User;
import ru.rikabc.models.enums.Priority;
import ru.rikabc.repositories.NoteRepository;
import ru.rikabc.services.NoteService;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository repository;

    @Override
    public boolean save(NoteForm note) {
        Note candidateNote = new Note();
        candidateNote.setCreateDate(Date.valueOf(LocalDate.now()));
        candidateNote.setHeader(note.getHeader());
        candidateNote.setPriority(Priority.valueOf(note.getPriority()));

        if (note.getNote() == null || note.getNote().equals("")) {
            candidateNote.setNote("Non");
        } else {
            candidateNote.setNote(note.getNote());
        }
        candidateNote.setUser(new User(note.getUserId()));
        Note save = repository.save(candidateNote);
        return save != null;
    }

    @Override
    public void delete(Long fileId) {
        repository.delete(fileId);
    }
}
