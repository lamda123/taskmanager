package com.example.taskmanager.profile;

import com.example.taskmanager.exception.ResourceAlreadyPresentExcpetion;
import com.example.taskmanager.exception.ResourceNotFoundException;

public interface ISignUpService {
    boolean checkIfAccountAlreadyExists(String email);
    UserResponse createUserAccount(UserRequest u) throws ResourceNotFoundException,
            ResourceAlreadyPresentExcpetion;
}
