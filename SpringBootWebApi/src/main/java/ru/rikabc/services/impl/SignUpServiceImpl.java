package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rikabc.models.User;
import ru.rikabc.models.enums.Role;
import ru.rikabc.models.enums.Status;
import ru.rikabc.repositories.UserRepository;
import ru.rikabc.services.SignUpService;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public boolean signUpNewUser(User user) {
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.USER);
        String hashPassword = encoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        try {
            user.setId(repository.save(user).getId());
            return true;
        } catch (DataIntegrityViolationException e) {
            return false;
        }
    }
}
