package com.project.first_project.service;

import com.project.first_project.dto.UserDto;
import com.project.first_project.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    

    List<UserEntity> getAllUsers();

    UserEntity getAllUserbyId(Long id);

    UserEntity updateUser(Long id, UserDto userDto);

    UserEntity createUser(UserEntity newUser);

    // Object createUser(UserEntity newUser);
}
