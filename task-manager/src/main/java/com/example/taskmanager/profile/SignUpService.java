package com.example.taskmanager.profile;

import com.example.taskmanager.exception.Messages;
import com.example.taskmanager.exception.ResourceAlreadyPresentExcpetion;
import com.example.taskmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService implements ISignUpService {
    @Autowired
    SignUpRepostiory signUpRepostiory;
    @Override
    public boolean checkIfAccountAlreadyExists(String email) {
        return  signUpRepostiory.checkIfAccountExists(email);
    }

    @Override
    public UserResponse createUserAccount(UserRequest u) throws ResourceNotFoundException,
            ResourceAlreadyPresentExcpetion {

        if(checkIfAccountAlreadyExists(u.getEmail())){
            throw new ResourceAlreadyPresentExcpetion(Messages.USER_ALREADY_PRESENT);
        }

        User user = SignUpMapper.convertUserRequestToEntity(u);
        Optional<User> userOptional =Optional.of(signUpRepostiory.save(user));
        UserResponse userResponse = userOptional.map(obj -> {
           final User userEntity= userOptional.get();
           return SignUpMapper.convertEntityToResponse(userEntity);
        }).orElseThrow(()-> new ResourceNotFoundException("UserRequest with email "+ u.email +" is "
                + " not created successfully"));
            return userResponse;
    }

}
