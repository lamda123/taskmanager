package com.example.taskmanager.exception;

public class ResourceAlreadyPresentExcpetion extends Exception {
    public ResourceAlreadyPresentExcpetion(){

    }
   public ResourceAlreadyPresentExcpetion(String message){
        super(message);
   }

}
