package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rikabc.form.UserForm;
import ru.rikabc.models.User;
import ru.rikabc.models.enums.Role;
import ru.rikabc.models.enums.Status;
import ru.rikabc.repositories.UserRepository;
import ru.rikabc.services.SignUpService;
import ru.rikabc.utility.UserInputValidator;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public boolean createNewUser(UserForm user) {
        if (!UserInputValidator.validLoginAndPassword(user))
            return false;

        User candidateUser = new User();
        candidateUser.setStatus(Status.ACTIVE);
        candidateUser.setRole(Role.USER);
        candidateUser.setUsername(user.getUsername());
        candidateUser.setPassword(encoder.encode(user.getPassword()));
        return repository.save(candidateUser);
    }
}
