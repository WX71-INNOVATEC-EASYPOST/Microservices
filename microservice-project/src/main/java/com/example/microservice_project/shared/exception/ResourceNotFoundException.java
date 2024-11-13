package com.example.microservice_project.shared.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}