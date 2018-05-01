package ru.rikabc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rikabc.models.Note;

import java.util.List;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserId(Long id);
}
