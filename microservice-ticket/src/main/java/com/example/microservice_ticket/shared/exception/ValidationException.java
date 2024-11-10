package com.example.microservice_ticket.shared.exception;

public class ValidationException extends  RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}