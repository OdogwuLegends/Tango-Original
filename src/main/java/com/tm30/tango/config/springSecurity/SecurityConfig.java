package com.tm30.tango.config.springSecurity;

import com.tm30.tango.config.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer:: disable)
                .authorizeHttpRequests(request-> request.requestMatchers(NO_AUTH_ENDPOINTS).permitAll()
                        .requestMatchers("/api/v1/auth/change-password").authenticated()
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    private String[] noAuthEndPoints(){
//        return new String[]{ "/api/v1/auth/login",
//                "/api/v1/auth/initiate-password-reset",
//                "/api/v1/auth/complete-password-reset"
//        };
//    }


    private static final String[] NO_AUTH_ENDPOINTS = {
            "/api/v1/auth/login",
            "/api/v1/auth/initiate-password-reset",
            "/api/v1/auth/complete-password-reset"
    };
}
