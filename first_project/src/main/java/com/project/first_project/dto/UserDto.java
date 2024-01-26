package com.project.first_project.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private  String name;
    @Column(name = "email", unique = true)
    private String email;
    private String username;
    private String password;
}
