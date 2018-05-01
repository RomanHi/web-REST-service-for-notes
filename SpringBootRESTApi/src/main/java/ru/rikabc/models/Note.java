package ru.rikabc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rikabc.models.enums.Priority;

import java.sql.Date;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {
    private Long noteId;
    private String note;
    private String header;
    private Date createDate;
    private Priority priority;
    private Long userId;
}
