package com.example.microservice_ticket.easypost.service.Impl;

import com.example.microservice_ticket.easypost.model.Ticket;
import com.example.microservice_ticket.easypost.model.enums.Status;
import com.example.microservice_ticket.easypost.repository.TicketRepository;
import com.example.microservice_ticket.easypost.service.TicketService;
import com.example.microservice_ticket.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(()-> new ValidationException("Ticket not found"));
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getAllTicketsByStatus(Status status) {
        return ticketRepository.findAllByStatus(status);
    }

}
