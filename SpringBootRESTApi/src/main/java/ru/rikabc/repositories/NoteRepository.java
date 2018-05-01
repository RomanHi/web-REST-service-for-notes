package ru.rikabc.repositories;

import ru.rikabc.models.Note;

import java.util.List;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public interface NoteRepository extends BaseDao<Note> {
    List<Note> findAll(Long id);

    Note findNoteById(Long id);

    Note saveNote(Note note);
}
