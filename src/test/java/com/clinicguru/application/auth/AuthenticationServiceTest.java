package com.clinicguru.application.auth;

import com.clinicguru.application.auth.fixtures.AuthenticationRequestFixture;
import com.clinicguru.application.auth.fixtures.RegisterRequestFixture;
import com.clinicguru.application.auth.fixtures.TokenFixture;
import com.clinicguru.application.auth.fixtures.UserFixture;
import com.clinicguru.application.auth.models.AuthenticationRequest;
import com.clinicguru.application.auth.models.AuthenticationResponse;
import com.clinicguru.application.auth.models.RegisterRequest;
import com.clinicguru.application.config.JWTService;
import com.clinicguru.application.token.Token;
import com.clinicguru.application.token.TokenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JWTService jwtService;
    @Mock
    private TokenRepository tokenRepository;
    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Test
    void GivenCreateUser_WhenValidUser_ThenReturnCreatedUser() {
        RegisterRequest registerRequest = RegisterRequestFixture.create();
        User user = UserFixture.create();
        String bcryptPassword = "123";
        Token token = TokenFixture.createWithUser(user);

        when(passwordEncoder.encode(any())).thenReturn(bcryptPassword);
        when(userRepository.save(any())).thenReturn(user);
        when(jwtService.generateToken(any())).thenReturn(token.getToken());
        when(jwtService.generateRefreshToken(any())).thenReturn(token.getToken());
        when(tokenRepository.save(any())).thenReturn(token);

        AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);

        assertNotNull(authenticationResponse);
        assertNotNull(authenticationResponse.getAccessToken());
        assertNotNull(authenticationResponse.getRefreshToken());
    }

    @Test
    void GivenAuthenticate_WhenValidRequest_ThenReturnGeneratedTokens() {
        AuthenticationRequest authenticationRequest = AuthenticationRequestFixture.create();
        User user = UserFixture.create();
        Token token = TokenFixture.createWithUser(user);
        List<Token> validUserTokens = Collections.singletonList(token);

        when(userRepository.findByUsername(any())).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any())).thenReturn(token.getToken());
        when(jwtService.generateRefreshToken(any())).thenReturn(token.getToken());
        when(tokenRepository.findAllValidTokenByUser(user.getId())).thenReturn(validUserTokens);
        when(tokenRepository.saveAll(any())).thenReturn(validUserTokens);
        when(tokenRepository.save(any())).thenReturn(token);

        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);

        assertNotNull(authenticationResponse);
        assertNotNull(authenticationResponse.getAccessToken());
        assertNotNull(authenticationResponse.getRefreshToken());
    }
}
