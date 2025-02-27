package com.example.authorization_service.repository;

import com.example.authorization_service.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    Optional<ClientEntity> findByClientId(String clientId);
}
