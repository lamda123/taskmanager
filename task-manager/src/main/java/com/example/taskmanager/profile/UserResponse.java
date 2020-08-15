package com.example.taskmanager.profile;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Data
public class UserResponse {

        @NotNull(message = "Name cannot be Null")
        private String name;

        @Email(message = "Email cannot be empty")
        private String email;

       // byte[] pic;
       private boolean scccess;

}
