package com.example.authorization_service.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "security")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;
    private final String scope;


    public ClientEntity(String clientId, String clientSecret,
                        String redirectUri, String scope) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.scope = scope;
    }

    public UUID getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getScope() {
        return scope;
    }

}
