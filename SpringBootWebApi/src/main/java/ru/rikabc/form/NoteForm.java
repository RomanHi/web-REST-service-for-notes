package ru.rikabc.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteForm {
    private long userId;
    private String note;
    private String header;
    private String priority;
}
