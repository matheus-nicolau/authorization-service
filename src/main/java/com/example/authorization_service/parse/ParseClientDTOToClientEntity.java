package com.example.authorization_service.parse;

import com.example.authorization_service.dto.ClientDTO;
import com.example.authorization_service.entity.ClientEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ParseClientDTOToClientEntity {

    private final PasswordEncoder encoder;

    public ParseClientDTOToClientEntity(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public ClientEntity parse(ClientDTO clientDTO) {
        var secretEncoded = encoder.encode(clientDTO.clientSecret());
        return  new ClientEntity(clientDTO.clientId(),
                                 secretEncoded,
                                 clientDTO.redirectUri(),
                                 clientDTO.scope());
    }
}
