package com.example.authorization_service.dto;

import java.util.List;

public record UserCreateDTO(
        String login,
        String password,
        List<String> roles,
        String email
) {}
