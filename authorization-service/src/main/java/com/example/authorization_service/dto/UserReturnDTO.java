package com.example.authorization_service.dto;

import java.util.List;

public record UserReturnDTO(
        String login,
        List<String> roles,
        String email
) {}
