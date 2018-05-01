package ru.rikabc.services;

import org.springframework.security.core.AuthenticationException;
import ru.rikabc.form.UserForm;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public interface LoginService {
    String login(UserForm userForm) throws AuthenticationException, IllegalStateException;
}
