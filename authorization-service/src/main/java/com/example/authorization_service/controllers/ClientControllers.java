package com.example.authorization_service.controllers;

import com.example.authorization_service.dto.ClientRecord;
import com.example.authorization_service.entity.ClientEntity;
import com.example.authorization_service.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorize")
public class ClientControllers {

    private final ClientService clientService;

    public ClientControllers(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientEntity> saveClient(@RequestBody ClientRecord client) {
        ClientEntity clientEntitySaved = clientService.save(client);
        return  ResponseEntity.status(HttpStatus.CREATED).body(clientEntitySaved);
    }
}
