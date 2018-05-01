package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import ru.rikabc.form.UserForm;
import ru.rikabc.services.LoginService;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Author Roman Khayrullin on 29.04.2018
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService service;

    @GetMapping
    public String getLogin() {
        return "login";
    }

    @PostMapping
    public ResponseEntity<String> postLogin(@RequestBody UserForm user) {
        try {
            return ResponseEntity.ok("put you token in header \"Authorization\"\n" + service.login(user));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(BAD_REQUEST).body("invalid username or password");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(BAD_REQUEST).body("input username and password like this:" +
                    " {\"username\" : \"?\", \"password\" : \"?\"}");
        }
    }
}
