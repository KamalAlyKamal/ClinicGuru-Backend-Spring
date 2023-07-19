package com.clinicguru.application.auth.fixtures;

import com.clinicguru.application.auth.models.AuthenticationRequest;

public class AuthenticationRequestFixture {

    public static AuthenticationRequest create() {
        return AuthenticationRequest.builder()
                .username("test")
                .password("123")
                .build();
    }
}
