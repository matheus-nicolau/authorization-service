package com.example.authorization_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    private ResponseEntity<String> getHome() {
        return  ResponseEntity.status(HttpStatus.OK).body("<h1>Página Home</h1>");
    }
}
