package ru.rikabc.services;

import ru.rikabc.models.Note;

import java.util.List;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
public interface ProfileService {
    List<Note> getAllNotes(Long id);
}
