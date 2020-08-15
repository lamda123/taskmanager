package com.example.taskmanager.profile;

public class SignUpMapper {
    public  static User convertUserRequestToEntity(
            UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(Encryption.encrypt(userRequest.getPassword()));
        user.setPic(userRequest.getPic());
        return user;
    }

    public  static UserResponse convertEntityToResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
      //  userResponse.setPic(user.getPic());
        return userResponse;
    }
}
