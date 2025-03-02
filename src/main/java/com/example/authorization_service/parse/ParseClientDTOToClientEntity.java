package com.example.authorization_service.parse;

import com.example.authorization_service.dto.ClientDTO;
import com.example.authorization_service.entity.ClientEntity;

public class ParseClientDTOToClientEntity {

    public ClientEntity parse(ClientDTO clientDTO) {
        return  new ClientEntity(clientDTO.clientId(),
                                 clientDTO.clientSecret(),
                                 clientDTO.redirectUri(),
                                 clientDTO.scope());
    }
}
