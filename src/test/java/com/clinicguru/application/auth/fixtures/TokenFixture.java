package com.clinicguru.application.auth.fixtures;

import com.clinicguru.application.auth.User;
import com.clinicguru.application.token.Token;

import java.util.UUID;

public class TokenFixture {

    public static Token create() {
        return Token.builder()
                .id(UUID.randomUUID())
                .token("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYW1hbDciLCJpYXQiOjE2ODkwOTk0MjEsImV4cCI6MTY4OTE4NTgyMX0.-T8DFjYpu1E-mtXkLJHIji-WBRpkokN4ws-twyZeJ0o")
                .tokenType("BEARER")
                .revoked(false)
                .expired(false)
                .user(null)
                .build();
    }

    public static Token createWithUser(User user) {
        Token token = create();
        token.setUser(user);
        return token;
    }
}
