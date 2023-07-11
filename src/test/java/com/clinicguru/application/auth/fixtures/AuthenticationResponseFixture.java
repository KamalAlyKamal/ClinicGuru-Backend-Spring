package com.clinicguru.application.auth.fixtures;

import com.clinicguru.application.auth.models.AuthenticationResponse;

public class AuthenticationResponseFixture {

    public static AuthenticationResponse create() {
        return AuthenticationResponse.builder()
                .accessToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYW1hbDYiLCJpYXQiOjE2ODkwOTcwOTksImV4cCI6MTY4OTE4MzQ5OX0.MfUFMynBKBqk8x8kCfk4zjizJepG0ThhPA7gAvaYbHc")
                .refreshToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYW1hbDYiLCJpYXQiOjE2ODkwOTcwOTksImV4cCI6MTY4OTcwMTg5OX0.YCsu93fzM1nt1zddw6S6SjBzAityM6IZdzcXGhT44Zo")
                .build();
    }
}
