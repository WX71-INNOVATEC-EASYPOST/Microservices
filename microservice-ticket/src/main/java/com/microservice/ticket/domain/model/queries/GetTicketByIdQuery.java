package com.microservice.ticket.domain.model.queries;

public record GetTicketByIdQuery(Long id) {
    public GetTicketByIdQuery {
        if (id == null || id == 0) {
            throw new IllegalArgumentException("Ticket id is required");
        }
    }
}
