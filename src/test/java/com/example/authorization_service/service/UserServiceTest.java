package com.example.authorization_service.service;

import com.example.authorization_service.dto.UserCreateDTO;
import com.example.authorization_service.entity.UserEntity;
import com.example.authorization_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRepository usersRepository;
    @InjectMocks
    UserService userService;

    private UserEntity userEntity;

    @BeforeEach
    public void setup() {
        userEntity = new UserEntity("matheus",
                "1234",
                List.of("ADMIN"),
                "nicolau.test@gmail.com");
    }

    @Test
    @DisplayName("Should be save a person.")
    void givenHaveAPerson_whenTryToSave_thenMustSave() {
        // GIVEN
        var userDTO = createUserDTO();
        when(passwordEncoder.encode(userDTO.password())).thenReturn(anyString());
        // WHEN
        userService.creteUser(userDTO);
    }

    @Test
    @DisplayName("Should be find a user by login.")
    void givenHaveALogin_whenSearchUserByLogin_thenReturnThisUser() {
        // GIVEN
        when(usersRepository.findByLogin(anyString())).thenReturn(Optional.of(userEntity));
        // WHEN
        UserEntity userByLogin = userService.findByLogin(anyString());
        // THEN
        assertEquals(userByLogin, userEntity);
    }

    @Test
    @DisplayName(" Description ")
    void given_when_then() {
        // GIVEN


        // WHEN


        // THEN


    }


    private UserCreateDTO createUserDTO() {
        return new UserCreateDTO(
                            "matheus",
                            "1234",
                            List.of("ADMIN"),
                            "nicolau.test@gmail.com");
    }

}