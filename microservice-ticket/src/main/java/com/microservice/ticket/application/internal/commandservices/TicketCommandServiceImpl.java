package com.microservice.ticket.application.internal.commandservices;

import com.microservice.ticket.domain.model.commands.CreateTicketCommand;
import com.microservice.ticket.domain.model.entity.Ticket;
import com.microservice.ticket.domain.services.TicketCommandService;
import com.microservice.ticket.infrastructure.persistence.jpa.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketCommandServiceImpl implements TicketCommandService {
    private final TicketRepository ticketRepository;

    public TicketCommandServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> handle(CreateTicketCommand command) {
        Ticket ticket = new Ticket(command);
        var createdTicket = ticketRepository.save(ticket);
        return Optional.of(createdTicket);
    }
}
