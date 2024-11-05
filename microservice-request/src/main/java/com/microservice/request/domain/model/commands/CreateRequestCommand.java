package com.microservice.request.domain.model.commands;

import java.time.LocalDateTime;

public record CreateRequestCommand(
        Long userIdFrom,
        Long userIdTo,
        String requestTitle,
        String requestDescription,
        String requestStatus,
        Long locationId,
        LocalDateTime issueDate
) {
    public CreateRequestCommand {
        if (userIdFrom == null || userIdFrom < 0) {
            throw new IllegalArgumentException("User ID From cannot be null or negative");
        }
        if (userIdTo == null || userIdTo < 0) {
            throw new IllegalArgumentException("User ID To cannot be null or negative");
        }
        if (requestTitle == null || requestTitle.isBlank()) {
            throw new IllegalArgumentException("Request's Title cannot be null or empty");
        }
        if (requestDescription == null || requestDescription.isBlank()) {
            throw new IllegalArgumentException("Request's Description cannot be null or empty");
        }
        if (requestStatus == null || requestStatus.isBlank()) {
            throw new IllegalArgumentException("Request's status cannot be null or empty");
        }
        if (locationId == null || locationId < 0) {
            throw new IllegalArgumentException("Location ID cannot be null or negative");
        }
        if (issueDate == null) {
            throw new IllegalArgumentException("Issue Date cannot be null");
        }
    }
}
