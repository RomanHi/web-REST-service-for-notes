package ru.rikabc.models;

import lombok.*;
import ru.rikabc.models.enums.Role;
import ru.rikabc.models.enums.Status;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "notes")
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(STRING)
    private Role role;
    @Enumerated(STRING)
    private Status status;

    @OneToMany
    private List<Note> notes;

    public User(Long id) {
        this.id = id;
    }
}
