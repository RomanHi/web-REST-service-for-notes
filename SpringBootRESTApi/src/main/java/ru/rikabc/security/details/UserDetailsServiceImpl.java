package ru.rikabc.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rikabc.models.User;
import ru.rikabc.repositories.UserRepository;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        try {
            user = repository.findUserById(new Long(s));
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("user not found");
        }
        if (user == null)
            throw new UsernameNotFoundException("user not found");
        return new UserDetailsImpl(user);
    }
}
