package com.microservice.request.domain.model.commands;

public record CreateRequestCommand(String requestTitle, String requestDescription, String requestStatus) {
    public CreateRequestCommand{
        if (requestTitle == null || requestTitle.isBlank()) {
            throw new IllegalArgumentException("Request's Title cannot be null or empty");
        }
        if (requestDescription == null || requestDescription.isBlank()) {
            throw new IllegalArgumentException("Request's Description cannot be null or empty");
        }
        if (requestStatus == null || requestStatus.isBlank()) {
            throw new IllegalArgumentException("Request's status cannot be null or empty");
        }
    }
}
