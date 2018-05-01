package ru.rikabc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rikabc.models.enums.Priority;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "note", schema = "public")
public class Note {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long noteId;
    private String note;
    private String header;
    private Date createDate;
    @Enumerated(STRING)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
