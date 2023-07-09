package com.clinicguru.application.user;

import com.clinicguru.application.config.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel createUser(UserModel userModel) {
        UserEntity userEntity = this.modelMapper.map(userModel, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encoder().encode(userEntity.getPassword()));
        UserEntity createdUserEntity =  this.userRepository.save(userEntity);
        return this.modelMapper.map(createdUserEntity, UserModel.class);
    }
}
