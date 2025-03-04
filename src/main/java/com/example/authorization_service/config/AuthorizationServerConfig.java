package com.example.authorization_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

@Configuration
@EnableWebSecurity
public class AuthorizationServerConfig {

    @Bean
    @Order(1)
    SecurityFilterChain authorizationSecurityFilterChain(HttpSecurity http) throws Exception{

        var authorizationConfigure = OAuth2AuthorizationServerConfigurer.authorizationServer();

        http
            .securityMatcher(authorizationConfigure.getEndpointsMatcher())
            .with(authorizationConfigure, (authorizationServer) ->
                                            authorizationServer.oidc(Customizer.withDefaults()))
            .authorizeHttpRequests(authorize ->
                                            authorize.anyRequest().authenticated())
            .oauth2ResourceServer(oauth ->
                                            oauth.jwt(Customizer.withDefaults()))
            .exceptionHandling(exceptions ->
                                            exceptions.defaultAuthenticationEntryPointFor(
                                                    new LoginUrlAuthenticationEntryPoint("/login"),
                                                    new MediaTypeRequestMatcher(MediaType.TEXT_HTML))
            );

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests((authorize) ->
                                                authorize.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder().build();
    }

    @Bean
    public ClientSettings clientSettings() {
        return ClientSettings.builder()
                             .requireAuthorizationConsent(false)
                             .build();
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }
}
