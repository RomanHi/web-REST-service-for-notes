package ru.rikabc.services;

import ru.rikabc.form.UserForm;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public interface SignUpService {
    boolean createNewUser(UserForm user);
}
