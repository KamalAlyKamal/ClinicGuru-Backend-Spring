package com.clinicguru.application.auth.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String email;
}
