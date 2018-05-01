package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rikabc.form.UserForm;
import ru.rikabc.models.User;
import ru.rikabc.repositories.UserRepository;
import ru.rikabc.services.JWTUtil;
import ru.rikabc.services.LoginService;
import ru.rikabc.utility.UserInputValidator;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JWTUtil jwtUtil;

    @Override
    public String login(UserForm userForm) throws AuthenticationException, IllegalStateException {
        if (!UserInputValidator.validLoginAndPassword(userForm))
            throw new IllegalStateException("incorrect input data");
        User user = repository.findUserByUsername(userForm.getUsername());
        boolean notFoundUser = user == null || !encoder.matches(userForm.getPassword(), user.getPassword());
        if (notFoundUser)
            throw new UsernameNotFoundException("invalid username or password");

        return jwtUtil.createToken(user.getId());
    }
}
