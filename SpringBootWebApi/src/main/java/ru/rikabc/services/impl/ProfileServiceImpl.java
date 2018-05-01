package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rikabc.models.Note;
import ru.rikabc.repositories.NoteRepository;
import ru.rikabc.services.ProfileService;

import java.util.List;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    NoteRepository repositoy;

    @Override
    public List<Note> getAllNotes(Long id) {
        List<Note> notes = repositoy.findAllByUserId(id);
        return notes;
    }
}
