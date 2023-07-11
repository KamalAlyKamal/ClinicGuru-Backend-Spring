package com.clinicguru.application.auth;

import com.clinicguru.application.auth.models.AuthenticationResponse;
import com.clinicguru.application.auth.models.RegisterRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    ResponseEntity<AuthenticationResponse> register(@NotNull @Valid @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
}
