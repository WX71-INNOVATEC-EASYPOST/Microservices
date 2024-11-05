package com.microservice.request.domain.model.commands;

public record DeleteRequestCommand(Long id) {
    public DeleteRequestCommand{
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
