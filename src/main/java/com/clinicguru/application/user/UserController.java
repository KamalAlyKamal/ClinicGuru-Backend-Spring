package com.clinicguru.application.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    ResponseEntity<UserModel> register(@NotNull @RequestBody UserModel userModel) {
        UserModel createdUserModel = userService.createUser(userModel);
        return new ResponseEntity<>(createdUserModel, HttpStatus.CREATED);
    }
}
