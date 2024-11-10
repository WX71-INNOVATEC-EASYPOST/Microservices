package com.example.microservice_ticket.easypost.dto.mapper;

import com.example.microservice_ticket.easypost.model.enums.Category;
import com.example.microservice_ticket.easypost.model.enums.Priority;
import com.example.microservice_ticket.easypost.model.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketResponse {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private Priority priority;
    private Long profileId;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdate;
}
