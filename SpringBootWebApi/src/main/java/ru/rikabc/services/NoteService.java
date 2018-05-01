package ru.rikabc.services;

import ru.rikabc.form.NoteForm;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
public interface NoteService {
    boolean save(NoteForm note);

    void delete(Long fileId);
}
