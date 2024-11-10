package com.example.microservice_ticket.easypost.repository;

import com.example.microservice_ticket.easypost.model.Ticket;
import com.example.microservice_ticket.easypost.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByStatus(Status status);
}
