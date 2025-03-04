package com.example.authorization_service.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(schema = "security", name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String scope;

    public ClientEntity() {}

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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
