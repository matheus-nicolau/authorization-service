package com.example.authorization_service.domain;

import com.example.authorization_service.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;
import java.util.stream.Collectors;

public record CustomAuthentication( UserEntity user) implements Authentication {

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return user.getRoles()
                .stream()
                .map((SimpleGrantedAuthority::new))
                .collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return user.getLogin();
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }
}
