package com.example.MessageService.shared.exception;

public class ValidationException extends  RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}