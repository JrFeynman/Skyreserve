package com.example.skyreserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF için yeni lambda stili
                .csrf(csrf -> csrf.disable())

                // Tüm istekleri serbest bırakmak için:
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // Basit HTTP Basic Auth'u kapatmak veya açmak isterseniz:
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
