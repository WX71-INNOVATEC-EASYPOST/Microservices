package com.microservice.ticket.domain.services;

import com.microservice.ticket.domain.model.entity.Ticket;
import com.microservice.ticket.domain.model.queries.GetAllTicketsByStatusQuery;
import com.microservice.ticket.domain.model.queries.GetAllTicketsQuery;
import com.microservice.ticket.domain.model.queries.GetTicketByIdQuery;

import java.util.List;
import java.util.Optional;

public interface TicketQueryService {
    Optional<Ticket> handle(GetTicketByIdQuery query);
    List<Ticket> handle(GetAllTicketsQuery query);
    List<Ticket> handle(GetAllTicketsByStatusQuery query);
}
