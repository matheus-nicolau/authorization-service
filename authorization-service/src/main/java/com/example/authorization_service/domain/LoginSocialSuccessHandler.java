package com.example.authorization_service.domain;

import com.example.authorization_service.entity.UserEntity;
import com.example.authorization_service.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class LoginSocialSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private final UserService usersService;

    public LoginSocialSuccessHandler(UserService usersService) {
        this.usersService = usersService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) authentication;

        Map<String, Object> attributes = authenticationToken.getPrincipal().getAttributes();
        String email = attributes.get("email").toString();

        UserEntity user = usersService.findByEmail(email);
        authentication = new CustomAuthentication(user);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
