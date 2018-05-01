package ru.rikabc.repositories;


import ru.rikabc.models.User;

/**
 * @Author Roman Khayrullin on 18.03.2018
 * @Version 1.0
 */
public interface UserRepository extends BaseDao<User> {
    User findUserByUsername(String username);

    User findUserById(Long username);

    boolean save(User user);
}
