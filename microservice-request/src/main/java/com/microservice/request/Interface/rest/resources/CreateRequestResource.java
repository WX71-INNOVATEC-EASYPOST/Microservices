package com.microservice.request.Interface.rest.resources;

import java.time.LocalDateTime;

public record CreateRequestResource(Long userIdFrom, Long userIdTo, String title, String description, String status, Long locationId, LocalDateTime issueDate) {
    public CreateRequestResource {
        if (userIdFrom == null) {
            throw new IllegalArgumentException("userIdFrom is required");
        }
        if (userIdTo == null) {
            throw new IllegalArgumentException("userIdTo is required");
        }
        if (title == null) {
            throw new IllegalArgumentException("title is required");
        }
        if (description == null) {
            throw new IllegalArgumentException("description is required");
        }
        if (status == null) {
            throw new IllegalArgumentException("status is required");
        }
        if (locationId == null) {
            throw new IllegalArgumentException("locationId is required");
        }
        if (issueDate == null) {
            throw new IllegalArgumentException("issueDate is required");
        }
    }
}
