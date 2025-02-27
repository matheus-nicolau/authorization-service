package com.example.authorization_service.service;

import com.example.authorization_service.dto.UserCreateDTO;
import com.example.authorization_service.dto.UserReturnDTO;
import com.example.authorization_service.entity.UserEntity;
import com.example.authorization_service.parse.ParseUserDTOToUsers;
import com.example.authorization_service.parse.ParseUserToUserDTO;
import com.example.authorization_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository usersRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    public void creteUser(UserCreateDTO user) {
        String password = passwordEncoder.encode(user.password());
        UserEntity usersEntityToSave = new ParseUserDTOToUsers().parse(user, password);
        usersRepository.save(usersEntityToSave);
    }

    public UserEntity findByLogin(String login) {
        Optional<UserEntity> userFinded = usersRepository.findByLogin(login);
        return userFinded.orElseGet(userFinded::orElseThrow);
    }

    public UserEntity findByEmail(String email) {
        Optional<UserEntity> userFinded = usersRepository.findByEmail(email);
        return userFinded.orElseGet(userFinded::orElseThrow);
    }

    public List<UserReturnDTO> findAllUsers() {
        List<UserEntity> usersEntityList = usersRepository.findAll();
        return new ParseUserToUserDTO().parseList(usersEntityList);
    }
}
