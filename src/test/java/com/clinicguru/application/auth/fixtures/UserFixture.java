package com.clinicguru.application.auth.fixtures;

import com.clinicguru.application.auth.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserFixture {

    public static User create() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("test");
        user.setPassword("123");
        user.setEmail("test@test.com");
        user.setFirstName("test");
        user.setLastName("test");
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setCreatedAt(localDateTime);
        user.setUpdatedAt(localDateTime);
        return user;
    }
}
