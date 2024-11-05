package com.microservice.request.domain.model.commands;

public record UpdateStatusRequestCommand(Long id, String requestStatus) {
    public UpdateStatusRequestCommand{
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        if (requestStatus == null || requestStatus.isBlank()) {
            throw new IllegalArgumentException("Request's status cannot be null or empty");
        }
    }
}
