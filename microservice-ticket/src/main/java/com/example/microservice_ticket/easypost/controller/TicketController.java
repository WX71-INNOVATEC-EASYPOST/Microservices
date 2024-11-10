package com.example.microservice_ticket.easypost.controller;

import com.example.microservice_ticket.easypost.model.Ticket;
import com.example.microservice_ticket.easypost.model.enums.Status;
import com.example.microservice_ticket.easypost.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.ok(createdTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> allTickets = ticketService.getAllTickets();
        return ResponseEntity.ok(allTickets);
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<Ticket>> getTicketByStatus(@PathVariable Status status) {
        List<Ticket> allTicketsByStatus = ticketService.getAllTicketsByStatus(status);
        return ResponseEntity.ok(allTicketsByStatus);
    }
}
