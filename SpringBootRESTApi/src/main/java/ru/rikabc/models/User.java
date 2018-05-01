package ru.rikabc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rikabc.models.enums.Role;
import ru.rikabc.models.enums.Status;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private Status status;

}
