package ru.rikabc.repositories.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rikabc.models.User;
import ru.rikabc.repositories.UserRepository;
import ru.rikabc.utility.UserMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author Roman Khayrullin on 06.04.2018
 * @Version 1.0
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    @Value("${sql.user.save}")
    private String INSERT_USER;
    @Value("${sql.user.findByUsername}")
    private String SELECT_USER_BY_USERNAME;
    @Value("${sql.user.findById}")
    private String SELECT_USER_BY_ID;
    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(@Qualifier("dataSource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = new User();
        List<User> list = jdbcTemplate.query(SELECT_USER_BY_USERNAME, new Object[]{username}, new UserMapper());
        if (!list.isEmpty())
            user = list.get(0);
        return user;
    }

    @Override
    public User findUserById(Long id) {
        User user = new User();
        List<User> list = jdbcTemplate.query(SELECT_USER_BY_ID, new Object[]{id}, new UserMapper());
        if (!list.isEmpty())
            user = list.get(0);
        return user;
    }

    @Override
    public boolean save(User user) {
        Object[] param = {user.getUsername(), user.getPassword(), user.getRole().name(), user.getStatus().name()};
        return jdbcTemplate.update(INSERT_USER, param) != 0;
    }
}
