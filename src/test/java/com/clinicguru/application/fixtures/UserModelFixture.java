package com.clinicguru.application.fixtures;

import com.clinicguru.application.user.UserModel;

public class UserModelFixture {

    public static UserModel create() {
        UserModel userModel = new UserModel();
        userModel.setUsername("test");
        userModel.setPassword("123");
        userModel.setEmail("test@test.com");
        userModel.setFirstName("test");
        userModel.setLastName("test");
        return userModel;
    }
}
