package ru.rikabc.repositories.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rikabc.models.Note;
import ru.rikabc.repositories.NoteRepository;
import ru.rikabc.utility.NoteMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
@Component
public class NoteRepositoryImpl implements NoteRepository {
    @Value("${sql.note.findById}")
    private String SELECT_NOTE_BY_ID;
    @Value("${sql.note.findAllById}")
    private String SELECT_ALL_NOTE_BY_ID;
    @Value("${sql.note.save}")
    private String INSERT_NOTE;
    @Value("${sql.note.update}")
    private String UPDATE_NOTE;
    @Value("${sql.note.delete}")
    private String DELETE_NOTE;
    private JdbcTemplate jdbcTemplate;

    public NoteRepositoryImpl(@Qualifier("dataSource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Note> findAll(Long id) {
        List<Note> list = jdbcTemplate.query(SELECT_ALL_NOTE_BY_ID, new Object[]{id}, new NoteMapper());
        return list;
    }

    @Override
    public Note findNoteById(Long id) {
        Note note = null;
        List<Note> list = jdbcTemplate.query(SELECT_NOTE_BY_ID, new Object[]{id}, new NoteMapper());
        if (!list.isEmpty())
            note = list.get(0);
        return note;
    }

    @Override
    public Note saveNote(Note model) {
        if (model.getNoteId() == null) {
            Object[] param = {model.getHeader(), model.getNote(), model.getCreateDate(), model.getUserId(), model.getPriority().name()};
            return jdbcTemplate.queryForObject(INSERT_NOTE, param, new NoteMapper());
        } else {
            Object[] param = {model.getHeader(), model.getNote(), model.getCreateDate(), model.getPriority().name(), model.getNoteId()};
            return jdbcTemplate.queryForObject(UPDATE_NOTE, param, new NoteMapper());
        }
    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(DELETE_NOTE, id) != 0;
    }

    @Override
    public List<Note> findAll() {
        return null;
    }

    @Override
    public boolean save(Note model) {
        return false;
    }
}
