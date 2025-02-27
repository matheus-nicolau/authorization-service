package com.example.authorization_service.parse;

import com.example.authorization_service.dto.ClientRecord;
import com.example.authorization_service.entity.ClientEntity;

public class ParseClientDTOToClientEntity {

    public ClientEntity parse(ClientRecord clientDTO) {
        return  new ClientEntity(clientDTO.clientId(),
                                 clientDTO.clientSecret(),
                                 clientDTO.redirectUri(),
                                 clientDTO.scope());
    }
}
