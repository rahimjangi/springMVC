package com.raiseup.springMVC.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user1= User.withUsername("user1")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails user2=User.withUsername("user1")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails user3= User.withUsername("user3")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails admin= User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return null;
    }
}
