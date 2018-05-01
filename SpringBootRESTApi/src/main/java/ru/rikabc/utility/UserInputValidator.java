package ru.rikabc.utility;

import ru.rikabc.form.NoteForm;
import ru.rikabc.form.UserForm;
import ru.rikabc.models.enums.Priority;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public class UserInputValidator {

    public static boolean validLoginAndPassword(UserForm user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null)
            return false;

        if (user.getPassword().isEmpty() || user.getUsername().isEmpty())
            return false;
        return true;
    }

    public static String validNote(NoteForm note) {
        String textNote = note.getNote();
        String header = note.getHeader();
        String priority = note.getPriority();

        if (textNote == null || textNote.isEmpty())
            return "param 'note' can't be empty";
        if (header == null || header.isEmpty())
            return "param 'header' can't be empty";
        if (priority == null || priority.isEmpty()) {
            note.setPriority("MINOR");
        } else {
            try {
                Priority.valueOf(priority);
            } catch (IllegalArgumentException e) {
                return "priority must be one of: 'CRITICAL', 'MAJOR', 'MINOR', 'TRIVIAL'";
            }
        }
        return "ok";
    }
}
