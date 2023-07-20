package com.clinicguru.application.auth;

import com.clinicguru.application.auth.fixtures.AuthenticationRequestFixture;
import com.clinicguru.application.auth.fixtures.AuthenticationResponseFixture;
import com.clinicguru.application.auth.fixtures.RegisterRequestFixture;
import com.clinicguru.application.auth.models.AuthenticationRequest;
import com.clinicguru.application.auth.models.AuthenticationResponse;
import com.clinicguru.application.auth.models.RegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    @Test
    void GivenPOSTRegisterAPI_WhenValidRegisterRequest_ThenReturn200AccessToken() throws Exception {
        RegisterRequest registerRequest = RegisterRequestFixture.create();
        AuthenticationResponse authenticationResponse = AuthenticationResponseFixture.create();

        when(authenticationService.register(any())).thenReturn(authenticationResponse);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/auth/register")
                        .content(asJsonString(registerRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.access_token").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.refresh_token").exists());
    }

    @Test
    void GivenPOSTRegisterAPI_WhenInvalidRegisterRequest_ThenReturn400() throws Exception {
        RegisterRequest registerRequest = RegisterRequestFixture.create();
        registerRequest.setUsername(null);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/auth/register")
                        .content(asJsonString(registerRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void GivenPOSTAuthenticateAPI_WhenValidAuthenticateRequest_ThenReturn200AccessToken() throws Exception {
        AuthenticationRequest authenticationRequest = AuthenticationRequestFixture.create();
        AuthenticationResponse authenticationResponse = AuthenticationResponseFixture.create();

        when(authenticationService.authenticate(any())).thenReturn(authenticationResponse);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(asJsonString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.access_token").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.refresh_token").exists());
    }

    @Test
    void GivenPOSTAuthenticateAPI_WhenInvalidAuthenticateRequest_ThenReturn400() throws Exception {
        AuthenticationRequest authenticationRequest = AuthenticationRequestFixture.create();
        authenticationRequest.setUsername(null);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(asJsonString(authenticationRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void GivenPOSTRefreshTokenAPI_WhenValidRefreshTokenRequest_ThenReturnAccessToken() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer 123");
//        AuthenticationController controller = new AuthenticationController(authenticationService);
//
//
//
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/auth/refresh-token");
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
