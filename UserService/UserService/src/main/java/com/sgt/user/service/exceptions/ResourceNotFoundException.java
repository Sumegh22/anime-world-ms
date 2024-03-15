package com.sgt.user.service.exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Resource could not be found on server !...");
    }


    public ResourceNotFoundException(String message){
        super(message);
    }

}
