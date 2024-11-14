package com.microservice.ticket.domain.services;

import com.microservice.ticket.domain.model.commands.CreateTicketCommand;
import com.microservice.ticket.domain.model.entity.Ticket;

import java.util.Optional;

public interface TicketCommandService {
    Optional<Ticket> handle(CreateTicketCommand command);
}
