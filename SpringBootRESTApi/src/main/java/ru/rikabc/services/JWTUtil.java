package ru.rikabc.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public interface JWTUtil {
    String createToken(Long id);

    Long verifyId(String token);

    Long getIdFromToken(String token) throws UsernameNotFoundException;
}
