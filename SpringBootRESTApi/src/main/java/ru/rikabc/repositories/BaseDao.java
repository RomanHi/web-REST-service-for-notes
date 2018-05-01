package ru.rikabc.repositories;

import java.util.List;

/**
 * @Author Roman Khayrullin on 06.04.2018
 * @Version 1.0
 */
public interface BaseDao<T> {
    List<T> findAll();

    boolean save(T model);

    default boolean update(T model) {
        return false;
    }

    default boolean delete(Long id) {
        return false;
    }
}
