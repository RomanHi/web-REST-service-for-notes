package ru.rikabc.form;

import lombok.Data;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Data
public class UserForm {
    private Long id;
    private String password;
    private String role;
    private String status;
    private String username;
}
