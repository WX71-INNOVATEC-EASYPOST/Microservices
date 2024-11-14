package com.microservice.ticket.Interface.rest.transform;

import com.microservice.ticket.Interface.rest.resources.TicketResource;
import com.microservice.ticket.domain.model.entity.Ticket;

public class TicketResourceFromEntityAssembler {
    public static TicketResource toResourceFromEntity(Ticket ticket) {
        return new TicketResource(
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getCategory(),
                ticket.getPriority(),
                ticket.getProfileId(),
                ticket.getStatus(),
                ticket.getCreatedAt(),
                ticket.getLastUpdate()
        );
    }
}
