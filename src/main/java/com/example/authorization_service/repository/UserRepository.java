package com.example.authorization_service.repository;

import com.example.authorization_service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByLogin(String login);

    Optional<UserEntity> findByEmail(String email);
}
