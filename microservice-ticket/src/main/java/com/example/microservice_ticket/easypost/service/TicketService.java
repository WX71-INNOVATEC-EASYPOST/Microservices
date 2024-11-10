package com.example.microservice_ticket.easypost.service;

import com.example.microservice_ticket.easypost.model.Ticket;
import com.example.microservice_ticket.easypost.model.enums.Status;

import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    Ticket getTicketById(Long id);
    List<Ticket> getAllTickets();
    List<Ticket> getAllTicketsByStatus(Status status);
}
