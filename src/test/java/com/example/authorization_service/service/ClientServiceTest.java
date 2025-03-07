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


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ParseClientDTOToClientEntity clientParse;
    @InjectMocks
    private ClientService clientService;

    private ClientDTO client;

    @BeforeEach
    public void setup() {
        ClientDTO client = new ClientDTO("1234567",
                "7654321",
                "http://redirecturi.test.com",
                "ADMIN");
    }

    @Test
    @DisplayName("Should be save a client")
    void shouldBeSaveAClient() {
        Mockito
                .when(clientService.save(client))
                .thenReturn(new ClientEntity());

        ClientEntity save = clientService.save(client);
        ClientEntity save1 = clientService.save(client);

        Assertions.assertEquals(save, save1);

    }

}
