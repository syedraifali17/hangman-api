package com.raif.hangman_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/api/auth/register",
                                "/api/auth/login",
                                "/api/game/**",
                                "/api/words/**",
                                "/api/stats/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // This is a placeholder bean — it satisfies Spring Boot 4's requirement
        // for a UserDetailsService to exist before it respects your SecurityConfig.
        // We are not actually using in-memory users for login —
        // our own register/login endpoints in UserService handle authentication.
        // This just stops Spring from generating the random password and
        // overriding our security configuration.
        return new InMemoryUserDetailsManager();
    }
}