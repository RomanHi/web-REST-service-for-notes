package ru.rikabc.security.token;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
public class TokenAuthentication implements Authentication {
    private String token;
    private boolean isAuthenticated;
    private Object userDetails;


    public TokenAuthentication(String token) {
        this.token = token;
    }

    public void setUserDetails(Object userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserDetails details = (UserDetails) userDetails;
        return details.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return token;
    }
}
