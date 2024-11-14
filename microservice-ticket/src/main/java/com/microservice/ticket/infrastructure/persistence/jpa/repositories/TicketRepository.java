package com.microservice.ticket.infrastructure.persistence.jpa.repositories;

import com.microservice.ticket.domain.model.entity.Ticket;
import com.microservice.ticket.domain.model.valueobjects.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByStatus(Status status);
}
