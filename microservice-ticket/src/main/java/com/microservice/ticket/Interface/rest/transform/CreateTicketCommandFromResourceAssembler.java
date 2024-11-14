package com.microservice.ticket.Interface.rest.transform;

import com.microservice.ticket.Interface.rest.resources.CreateTicketResource;
import com.microservice.ticket.domain.model.commands.CreateTicketCommand;

public class CreateTicketCommandFromResourceAssembler {
    public static CreateTicketCommand toCommandFromResource(CreateTicketResource createTicketResource) {
        return new CreateTicketCommand(
                createTicketResource.title(),
                createTicketResource.description(),
                createTicketResource.category(),
                createTicketResource.priority(),
                createTicketResource.profileId(),
                createTicketResource.status(),
                createTicketResource.createdAt(),
                createTicketResource.lastUpdate()
        );
    }
}
