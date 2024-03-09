package com.example.pocclientkeycloak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                request.requestMatchers("/publico").permitAll()
                        .anyRequest().authenticated()
        )
                .oauth2Login(withDefaults())
                .oauth2ResourceServer(conf -> conf.jwt(withDefaults()));
        return http.build();
    }
}
