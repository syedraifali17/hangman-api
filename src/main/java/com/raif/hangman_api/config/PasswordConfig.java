package com.raif.hangman_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// @Configuration tells Spring: "this class contains beans — objects Spring should
// create and manage for us"
public class PasswordConfig {

    @Bean
    // @Bean tells Spring: "create one instance of this and keep it available
    // for the whole application to use"
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        // BCryptPasswordEncoder is the actual implementation of BCrypt hashing
        // Spring will inject this wherever we write: PasswordEncoder passwordEncoder
    }
}