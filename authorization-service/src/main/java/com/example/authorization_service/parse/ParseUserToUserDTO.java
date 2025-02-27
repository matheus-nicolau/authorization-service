package com.example.authorization_service.parse;

import com.example.authorization_service.dto.UserCreateDTO;
import com.example.authorization_service.dto.UserReturnDTO;
import com.example.authorization_service.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class ParseUserToUserDTO {

    public UserCreateDTO parse(UserEntity user) {
        return new UserCreateDTO(user.getLogin(),
                user.getPassword(),
                user.getRoles(),
                user.getEmail());
    }

    public List<UserReturnDTO> parseList(List<UserEntity> userList) {

        List<UserReturnDTO> userReturnList = new ArrayList<>();
        userList.forEach((user) ->  {
            userReturnList.add(new UserReturnDTO(user.getLogin(), user.getRoles(), user.getEmail()));
        });

        return userReturnList;
    }
}
