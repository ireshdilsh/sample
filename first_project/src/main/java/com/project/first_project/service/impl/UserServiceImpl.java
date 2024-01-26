package com.project.first_project.service.impl;

import com.project.first_project.dto.UserDto;
import com.project.first_project.entity.UserEntity;
import com.project.first_project.repository.UserRepository;
import com.project.first_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public UserEntity getAllUserbyId(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public UserEntity updateUser(Long id, UserDto userDto) {

        UserEntity userEntity=userRepository.findById(id).orElse(null);

        if (userEntity!=null){

            userEntity.setName(userDto.getName());
            userEntity.setEmail(userDto.getEmail());
            userEntity.setUsername(userDto.getUsername());
            userEntity.setPassword(userDto.getPassword());

            return userRepository.save(userEntity);
        }else {
            return null;
        }
    }

    @Override
    public UserEntity createUser(UserEntity newUser) {
        //return null;
        return userRepository.save(newUser);
    }


}
