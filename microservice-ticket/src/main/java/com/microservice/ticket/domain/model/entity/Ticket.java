package com.microservice.ticket.domain.model.entity;

import com.microservice.ticket.domain.model.commands.CreateTicketCommand;
import com.microservice.ticket.domain.model.valueobjects.Category;
import com.microservice.ticket.domain.model.valueobjects.Priority;
import com.microservice.ticket.domain.model.valueobjects.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "priority", nullable = false)
    private Priority priority;

    @Column(name = "profile_id", nullable = false)
    private Long profileId;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    public Ticket(CreateTicketCommand command) {
        this.title = command.title();
        this.description = command.description();
        this.category = command.category();
        this.priority = command.priority();
        this.profileId = command.profileId();
        this.status = command.status();
        this.createdAt = command.createdAt();
        this.lastUpdate = command.lastUpdate();
    }
}
