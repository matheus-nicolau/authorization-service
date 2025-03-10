//package com.example.authorization_service.controllers;
//
//import com.example.authorization_service.dto.ClientDTO;
//import com.example.authorization_service.service.ClientService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.BDDMockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@WebMvcTest(ClientController.class)
//public class ClientControllerTest {
//
//    @MockitoBean
//    private ClientService clientService;
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper mapper;
//
//    private ClientDTO client;
//
//    @BeforeEach
//    public void setup() {
//        ClientDTO client = new ClientDTO("1234567",
//                "7654321",
//                "http://redirecturi.test.com",
//                "ADMIN");
//    }
//
//    @Test
//    @DisplayName("should be create a client")
//    void shouldBeCreateAClient() throws Exception {
//        //GIVEN
//        BDDMockito.given(clientService.save(any(ClientDTO.class)))
//                  .willAnswer((invocation) -> invocation.getArgument(0));
//
//        //WHEN
//        ResultActions request = mockMvc.perform(
//                post("/client/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(client))
//        );
//
//        //THEN
//        request.andDo(print())
//                .andExpect(jsonPath("$.clientId").value(client.clientId()));
//
//    }
//
//
//}
