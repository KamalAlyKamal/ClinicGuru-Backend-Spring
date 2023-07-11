package com.clinicguru.application.auth;

import com.clinicguru.application.auth.models.AuthenticationResponse;
import com.clinicguru.application.auth.models.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
}
