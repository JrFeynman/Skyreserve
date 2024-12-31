package com.example.skyreserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Tüm endpoint'lere izin verir
                        .allowedOrigins("http://localhost:5173") // Frontend'in çalıştığı adres
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP yöntemleri
                        .allowedHeaders("*") // Tüm başlıklar izinlidir
                        .allowCredentials(true); // Çerezleri ve oturum yönetimini etkinleştirir
            }
        };
    }
}
