package com.example.authorization_service.parse;

import com.example.authorization_service.dto.UserCreateDTO;
import com.example.authorization_service.entity.UserEntity;

public class ParseUserDTOToUsers {

    public UserEntity parse(UserCreateDTO userCreateDTO, String password) {
        return new UserEntity(userCreateDTO.login(),
                password,
                userCreateDTO.roles(),
                userCreateDTO.email());
    }
}
