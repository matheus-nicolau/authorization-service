package com.example.authorization_service.domain;

import com.example.authorization_service.entity.UserEntity;
import com.example.authorization_service.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService usersService;
    private final PasswordEncoder encoder;

    public CustomAuthenticationProvider(UserService usersService,
                                        PasswordEncoder encoder) {
        this.usersService = usersService;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String login = authentication.getName();
        final String password = authentication.getCredentials().toString();

        UserEntity returnedUser = usersService.findByLogin(login);
        boolean passwordIsMatch = encoder.matches(password, returnedUser.getPassword());

        if(passwordIsMatch) return new CustomAuthentication(returnedUser);

        throw new UsernameNotFoundException("Usuário e/ou Senha incorretos.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
