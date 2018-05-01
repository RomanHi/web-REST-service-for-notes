package ru.rikabc.utility;

import org.springframework.jdbc.core.RowMapper;
import ru.rikabc.models.Note;
import ru.rikabc.models.enums.Priority;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public class NoteMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet result, int i) throws SQLException {
        Note note = new Note();
        note.setUserId(result.getLong("user_id"));
        note.setNote(result.getString("note"));
        note.setHeader(result.getString("header"));
        note.setPriority(Priority.valueOf(result.getString("priority")));
        note.setNoteId(result.getLong("note_id"));
        note.setCreateDate(result.getDate("create_date"));
        return note;
    }
}
