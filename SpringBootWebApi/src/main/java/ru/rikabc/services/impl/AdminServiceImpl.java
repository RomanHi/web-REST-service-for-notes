package ru.rikabc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rikabc.form.UserForm;
import ru.rikabc.models.User;
import ru.rikabc.models.enums.Role;
import ru.rikabc.models.enums.Status;
import ru.rikabc.repositories.UserRepository;
import ru.rikabc.services.AdminService;

import java.util.List;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findCurrentUser(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void updateUser(UserForm user) {
        User candidateUser = repository.findOne(user.getId());
        candidateUser.setUsername(user.getUsername());
        candidateUser.setRole(Role.valueOf(user.getRole()));
        candidateUser.setStatus(Status.valueOf(user.getStatus()));
        if (user.getPassword() != null || !user.getPassword().equals(""))
            candidateUser.setPassword(encoder.encode(user.getPassword()));

        repository.save(candidateUser);
    }

}
