package com.example.authorization_service.repository;

import com.example.authorization_service.service.ClientService;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

@Component
public class CustomRegisteredClientRepository implements RegisteredClientRepository {

    private final ClientService clientService;
    private final TokenSettings tokenSettings;
    private final ClientSettings clientSettings;

    public CustomRegisteredClientRepository(ClientService clientService, TokenSettings tokenSettings,
                                            ClientSettings clientSettings) {
        this.clientService = clientService;
        this.tokenSettings = tokenSettings;
        this.clientSettings = clientSettings;
    }

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client = clientService.findClient(clientId);
        if(client == null) return null;

        return RegisteredClient
                            .withId(client.getId().toString())
                            .clientId(client.getClientId())
                            .clientSecret(client.getClientSecret())
                            .redirectUri(client.getRedirectUri())
                            .scope(client.getScope())
                            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                            .postLogoutRedirectUri("http://127.0.0.1:8080/")
                            .scope(OidcScopes.OPENID)
                            .scope(OidcScopes.PROFILE)
                            .tokenSettings(tokenSettings)
                            .clientSettings(clientSettings)
                            .build();
    }
}
