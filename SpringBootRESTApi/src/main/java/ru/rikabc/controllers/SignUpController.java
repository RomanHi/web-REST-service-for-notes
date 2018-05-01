package ru.rikabc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rikabc.form.UserForm;
import ru.rikabc.services.SignUpService;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

/**
 * @Author Roman Khayrullin on 30.04.2018
 * @Version 1.0
 */
@RestController
@RequestMapping("/signUp")
public class SignUpController {
    @Autowired
    SignUpService service;

    @GetMapping
    public String getSignUp() {
        return "signUp";
    }

    @PostMapping
    public ResponseEntity<String> postSignUp(@RequestBody UserForm user) {
        if (service.createNewUser(user)) {
            return new ResponseEntity<>("ok", OK);
        }
        return new ResponseEntity<>("bad data", BAD_REQUEST);
    }
}

