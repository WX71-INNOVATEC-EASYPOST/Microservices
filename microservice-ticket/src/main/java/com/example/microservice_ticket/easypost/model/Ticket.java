package com.example.microservice_ticket.easypost.model;

import com.example.microservice_ticket.easypost.model.enums.Category;
import com.example.microservice_ticket.easypost.model.enums.Priority;
import com.example.microservice_ticket.easypost.model.enums.Status;
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
}
