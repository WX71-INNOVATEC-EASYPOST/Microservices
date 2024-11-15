package com.microservice.ticket.Interface.rest.resources;

import com.microservice.ticket.domain.model.valueobjects.Category;
import com.microservice.ticket.domain.model.valueobjects.Priority;
import com.microservice.ticket.domain.model.valueobjects.Status;

import java.time.LocalDateTime;

public record TicketResource(
        String title,
        String description,
        Category category,
        Priority priority,
        Long profileId,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime lastUpdate
) {
}
