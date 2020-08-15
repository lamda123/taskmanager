package com.example.taskmanager.profile;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserRequest {

    @NotNull(message = "Name cannot be Null")
    String name;

    @NotNull(message = "Password cannot be Null")
    String password;

    @Email(message = "Email cannot be empty")
    String email;

    byte[] pic;
}
