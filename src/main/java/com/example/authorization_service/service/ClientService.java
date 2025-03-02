package com.example.authorization_service.service;

import com.example.authorization_service.dto.ClientDTO;
import com.example.authorization_service.entity.ClientEntity;
import com.example.authorization_service.parse.ParseClientDTOToClientEntity;
import com.example.authorization_service.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientEntity save(ClientDTO client) {
        ClientEntity clientToSave = new ParseClientDTOToClientEntity().parse(client);
        return clientRepository.save(clientToSave);
    }

    public ClientEntity findByClientId(String clientId) {
        Optional<ClientEntity> clientOptional = clientRepository.findByClientId(clientId);
        return clientOptional.orElse(null);
    }
}
