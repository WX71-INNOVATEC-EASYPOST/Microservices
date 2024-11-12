package com.microservice.daily.activities.domain.model.commands;

import java.time.LocalDate;

public record CreateTaskCommand(String description, String taskStatus, Long assigneeId, LocalDate assignedDate, Long dailyActivityId) {
    public CreateTaskCommand {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (taskStatus == null || taskStatus.isBlank()) {
            throw new IllegalArgumentException("Task status cannot be null or empty");
        }
        if (assigneeId == null) {
            throw new IllegalArgumentException("Assignee ID cannot be null");
        }
        if (assignedDate == null) {
            throw new IllegalArgumentException("Assigned date cannot be null");
        }
        if (dailyActivityId == null) {
            throw new IllegalArgumentException("Daily Activity ID cannot be null");
        }
    }
}