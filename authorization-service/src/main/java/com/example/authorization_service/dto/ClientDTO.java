package com.example.authorization_service.dto;

public record ClientDTO(
        String clientId,
        String clientSecret,
        String redirectUri,
        String scope
) { }
