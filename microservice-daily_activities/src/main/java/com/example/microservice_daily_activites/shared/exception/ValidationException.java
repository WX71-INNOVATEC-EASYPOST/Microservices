package com.example.microservice_daily_activites.shared.exception;

public class ValidationException extends  RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}