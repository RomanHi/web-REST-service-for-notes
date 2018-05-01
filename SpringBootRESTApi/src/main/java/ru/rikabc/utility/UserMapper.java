package ru.rikabc.utility;

import org.springframework.jdbc.core.RowMapper;
import ru.rikabc.models.User;
import ru.rikabc.models.enums.Role;
import ru.rikabc.models.enums.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet result, int i) throws SQLException {
        User user = new User();
        user.setId(result.getLong("id"));
        user.setUsername(result.getString("username"));
        user.setPassword(result.getString("password"));
        user.setRole(Role.valueOf(result.getString("role")));
        user.setStatus(Status.valueOf(result.getString("status")));
        return user;
    }
}