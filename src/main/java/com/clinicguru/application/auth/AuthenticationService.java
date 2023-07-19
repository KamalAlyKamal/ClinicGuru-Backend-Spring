package com.clinicguru.application.auth;

import com.clinicguru.application.auth.models.AuthenticationRequest;
import com.clinicguru.application.auth.models.AuthenticationResponse;
import com.clinicguru.application.auth.models.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
