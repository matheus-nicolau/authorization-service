//package com.example.authorization_service.controllers;
//
//import com.example.authorization_service.service.ClientService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//@ExtendWith(MockitoExtension.class)
//public class ClientControllerTest {
//
//    @Mock
//    private MockMvc mockMvc;
//    @Mock
//    private ClientService clientService;
//    @InjectMocks
//    private ClientController clientController;
//
//
//    @BeforeEach
//    public void setup() {
//
//    }
//
//    @Test
//    @DisplayName("should be create a client")
//    void shouldBeCreateAClient() {
//
//        String body = "{\"clientId\": \"32379922\",\"clientSecret\": \"12345\",\"redirectUri\": \"http://localhost:8080/xatus\",\"scope\": \"ADMIN\"}";
//
//        try {
//            ResultActions httpRequest = mockMvc.perform(
//                    post("/client/create")
//                            .contentType("application/json")
//                            .content(body)
//                            .accept(MediaType.APPLICATION_JSON)
//            );
//
//            System.out.println(httpRequest.toString());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
