package com.example.microservice_project.shared.exception;

public class ValidationException extends  RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}