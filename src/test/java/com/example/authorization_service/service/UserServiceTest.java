package com.example.authorization_service.service;

import com.example.authorization_service.dto.UserCreateDTO;
import com.example.authorization_service.dto.UserReturnDTO;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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
        var userByLogin = userService.findByLogin(anyString());
        // THEN
        assertEquals(userByLogin, userEntity);
    }

    @Test
    @DisplayName("Should be find a user by email.")
    void givenHaveAEmail_whenSearchUserByEmail_thenReturnThisUser() {
        // GIVEN
        when(usersRepository.findByEmail(anyString())).thenReturn(Optional.of(userEntity));
        // WHEN
        var userByEmail = userService.findByEmail("nicolau.test@gmail.com");
        // THEN
        assertEquals(userByEmail, userEntity);
    }

    @Test
    @DisplayName("Should be find all users.")
    void givenHaveForAUserList_whenSearchThisList_thenReturnTheList() {
        // GIVEN
        var userReturnDTO = createUserReturnDTO();
        when(usersRepository.findAll()).thenReturn(List.of(userEntity));
        // WHEN
        var allUsers = userService.findAllUsers();
        // THEN
        assertEquals(allUsers, List.of(userReturnDTO));
    }

    private UserCreateDTO createUserDTO() {
        return new UserCreateDTO(
                            "matheus",
                            "1234",
                            List.of("ADMIN"),
                            "nicolau.test@gmail.com"
        );
    }

    private UserReturnDTO createUserReturnDTO() {
        return new UserReturnDTO(
                            "matheus",
                            List.of("ADMIN"),
                            "nicolau.test@gmail.com"
        );
    }
}