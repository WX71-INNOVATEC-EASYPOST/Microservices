package com.microservice.ticket.domain.model.commands;

import com.microservice.ticket.domain.model.valueobjects.Category;
import com.microservice.ticket.domain.model.valueobjects.Priority;
import com.microservice.ticket.domain.model.valueobjects.Status;

import java.time.LocalDateTime;

public record CreateTicketCommand(
        String title,
        String description,
        Category category,
        Priority priority,
        Long profileId,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime lastUpdate
) {
    public CreateTicketCommand {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title cannot be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be empty");
        }
        if (category == null) {
            throw new IllegalArgumentException("category cannot be null");
        }
        if (priority == null) {
            throw new IllegalArgumentException("priority cannot be null");
        }
        if (profileId == null) {
            throw new IllegalArgumentException("profileId cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("createdAt cannot be null");
        }
        if (lastUpdate == null) {
            throw new IllegalArgumentException("lastUpdate cannot be null");
        }
    }
}
