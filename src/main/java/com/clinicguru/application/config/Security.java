package com.clinicguru.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//public class Security {
//
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers(new AntPathRequestMatcher("/api/register")).permitAll()
//                        .anyRequest().authenticated())
//                .httpBasic();
//        return httpSecurity.build();
//    }
//}
