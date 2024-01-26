package com.project.first_project.secuirty;

import com.project.first_project.entity.UserEntity;
import com.project.first_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImplimentation implements UserDetailsService {

    @Autowired
     UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByUsername(username).orElse(null);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User is not found");
        }else {
            return User.builder()
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .build();
        }
    }
}
