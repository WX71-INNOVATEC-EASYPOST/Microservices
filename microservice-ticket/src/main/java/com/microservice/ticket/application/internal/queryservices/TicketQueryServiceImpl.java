package com.microservice.ticket.application.internal.queryservices;

import com.microservice.ticket.domain.model.entity.Ticket;
import com.microservice.ticket.domain.model.queries.GetAllTicketsByStatusQuery;
import com.microservice.ticket.domain.model.queries.GetAllTicketsQuery;
import com.microservice.ticket.domain.model.queries.GetTicketByIdQuery;
import com.microservice.ticket.domain.services.TicketQueryService;
import com.microservice.ticket.infrastructure.persistence.jpa.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketQueryServiceImpl implements TicketQueryService {
    private final TicketRepository ticketRepository;

    public TicketQueryServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> handle(GetTicketByIdQuery query) {
        return ticketRepository.findById(query.id());
    }

    @Override
    public List<Ticket> handle(GetAllTicketsQuery query) {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> handle(GetAllTicketsByStatusQuery query) {
        return ticketRepository.findAllByStatus(query.status());
    }
}
