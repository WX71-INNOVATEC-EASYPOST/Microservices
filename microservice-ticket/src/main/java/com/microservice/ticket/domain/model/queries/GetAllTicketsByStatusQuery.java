package com.microservice.ticket.domain.model.queries;

import com.microservice.ticket.domain.model.valueobjects.Status;

public record GetAllTicketsByStatusQuery(Status status) {
    public GetAllTicketsByStatusQuery {
        if(status == null){
            throw new IllegalArgumentException("Status must not be null");
        }
    }
}
