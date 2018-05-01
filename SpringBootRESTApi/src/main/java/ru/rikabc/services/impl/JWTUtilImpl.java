package ru.rikabc.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rikabc.services.JWTUtil;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

/**
 * @Author Roman Khayrullin on 28.04.2018
 * @Version 1.0
 */
@Service
public class JWTUtilImpl implements JWTUtil {
    @Value("${secret.key}")
    private String signingKey;

    @Override
    public String createToken(Long id) {
        try {
            Algorithm algorithmHS = Algorithm.HMAC256(signingKey);
            String token = JWT.create().withIssuer("auth0")
                    .withClaim("UserID", id)
                    .withClaim("Time", LocalDate.now().toString())
                    .sign(algorithmHS);
            return token;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long verifyId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(signingKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            String tokenTime = jwt.getClaim("Time").asString();
            if (!tokenTime.equals(LocalDate.now().toString()))
                throw new JWTVerificationException("expired token");
            return jwt.getClaim("UserID").asLong();
        } catch (JWTVerificationException | UnsupportedEncodingException e) {
            return -1L;
        }
    }

    @Override
    public Long getIdFromToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("UserID").asLong();
        } catch (JWTDecodeException e) {
            throw new UsernameNotFoundException("bad token");
        }
    }
}
