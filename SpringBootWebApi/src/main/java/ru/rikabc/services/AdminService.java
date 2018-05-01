package ru.rikabc.services;

import ru.rikabc.form.UserForm;
import ru.rikabc.models.User;

import java.util.List;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
public interface AdminService {
    List<User> getAllUsers();

    User findCurrentUser(Long id);

    void updateUser(UserForm user);
}
