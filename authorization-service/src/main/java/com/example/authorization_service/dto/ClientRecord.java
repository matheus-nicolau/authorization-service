package com.example.authorization_service.dto;

public record ClientRecord(
        String clientId,
        String clientSecret,
        String redirectUri,
        String scope
) { }
