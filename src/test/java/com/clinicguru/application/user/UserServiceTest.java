package com.clinicguru.application.user;

import com.clinicguru.application.config.PasswordEncoder;
import com.clinicguru.application.fixtures.UserEntityFixture;
import com.clinicguru.application.fixtures.UserModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private ModelMapper modelMapper;

    @Spy
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void GivenCreateUser_WhenValidUser_ThenReturnCreatedUser() {
        UserModel userModel = UserModelFixture.create();
        UserEntity createdUserEntity = UserEntityFixture.createFromUserModel(userModel);

        when(userRepository.save(any())).thenReturn(createdUserEntity);

        UserModel actualCreatedUser = userService.createUser(userModel);

        assertNotNull(actualCreatedUser);
        assertNotNull(actualCreatedUser.getId());
        assertNotNull(actualCreatedUser.getCreatedAt());
        assertNotNull(actualCreatedUser.getUpdatedAt());
    }
}
