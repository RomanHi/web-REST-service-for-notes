package ru.rikabc.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.rikabc.security.token.TokenAuthentication;
import ru.rikabc.services.JWTUtil;

/**
 * @Author Roman Khayrullin on 01.05.2018
 * @Version 1.0
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;
        Long id = jwtUtil.verifyId(tokenAuthentication.getName());

        if (!id.equals(-1L)) {
            Object userDetails = userDetailsService.loadUserByUsername(id.toString());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else throw new UsernameNotFoundException("Bad token");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
