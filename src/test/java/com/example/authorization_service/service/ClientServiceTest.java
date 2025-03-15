package com.example.authorization_service.service;

import com.example.authorization_service.dto.ClientDTO;
import com.example.authorization_service.entity.ClientEntity;
import com.example.authorization_service.parse.ParseClientDTOToClientEntity;
import com.example.authorization_service.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ParseClientDTOToClientEntity clientParse;
    @Mock
    private ClientEntity clientMock;
    @InjectMocks
    private ClientService clientService;

    private ClientDTO client;

    @BeforeEach
    public void setup() {
       client = new ClientDTO("1234567",
                "7654321",
                "http://redirecturi.test.com",
                "ADMIN");

    }

    @Test
    @DisplayName("Should be save a client")
    void givenHaveAClient_whenTryToSave_thenMustBeSave() {
        // WHEN
        Mockito.when(clientParse.parse(client)).thenReturn(clientMock);
        ClientEntity clientToSave = clientParse.parse(client);
        Mockito.when(clientRepository.save(clientToSave)).thenReturn(clientMock);

        ClientEntity clientSaved = clientService.save(client);

        // THEN
       Assertions.assertEquals(clientToSave, clientSaved);
    }

    @Test
    @DisplayName("Shold be find a client by id")
    void givenHaveAClientId_whenTryToFind_thenReturnTheClient() {
        // WHEN
        Mockito.when(clientRepository.findByClientId(client.clientId())).thenReturn(Optional.of(clientMock));

        ClientEntity clientById = clientService.findClient(client.clientId());

        // THEN
        Assertions.assertNotNull(clientById);
    }


}
