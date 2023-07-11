package com.clinicguru.application.auth.fixtures;

import com.clinicguru.application.auth.models.RegisterRequest;

public class RegisterRequestFixture {

    public static RegisterRequest create() {
        return RegisterRequest.builder()
                .username("test")
                .password("123")
                .email("test@test.com")
                .firstName("test")
                .lastName("test")
                .build();
    }
}
