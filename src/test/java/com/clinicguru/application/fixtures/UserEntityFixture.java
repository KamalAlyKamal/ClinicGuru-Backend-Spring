package com.clinicguru.application.fixtures;

import com.clinicguru.application.user.UserEntity;
import com.clinicguru.application.user.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserEntityFixture {

    public static UserEntity create() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setUsername("test");
        userEntity.setPassword("123");
        userEntity.setEmail("test@test.com");
        userEntity.setFirstName("test");
        userEntity.setLastName("test");
        LocalDateTime localDateTime = LocalDateTime.now();
        userEntity.setCreatedAt(localDateTime);
        userEntity.setUpdatedAt(localDateTime);
        return userEntity;
    }

    public static UserEntity createFromUserModel(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID());
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userModel.getLastName());
        LocalDateTime localDateTime = LocalDateTime.now();
        userEntity.setCreatedAt(localDateTime);
        userEntity.setUpdatedAt(localDateTime);
        return userEntity;
    }
}
