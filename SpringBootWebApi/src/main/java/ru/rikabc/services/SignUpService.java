package ru.rikabc.services;

import ru.rikabc.models.User;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
public interface SignUpService {
    boolean signUpNewUser(User user);
}
