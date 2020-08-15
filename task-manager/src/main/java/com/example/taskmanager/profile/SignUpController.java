package com.example.taskmanager.profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
    public static final String SUBMIT_URI="/submit";
    @Autowired
    ISignUpService signUpService;

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<String> getHealth() {
        return new ResponseEntity( "Task Manager running!!!",new HttpHeaders(),HttpStatus.OK);
    }

    @PostMapping(value=SUBMIT_URI,consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<UserResponse> signUpUser(@RequestBody UserRequest userRequest) throws Exception{
        UserResponse userResponseCreated =signUpService.createUserAccount(
                userRequest);
        if(userResponseCreated ==null){
           throw new Exception();
        }
        return new ResponseEntity(userResponseCreated, new HttpHeaders(), HttpStatus.OK);
    }



}
