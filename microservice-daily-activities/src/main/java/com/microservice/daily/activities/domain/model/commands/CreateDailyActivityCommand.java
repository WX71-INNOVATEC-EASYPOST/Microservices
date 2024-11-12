package com.microservice.daily.activities.domain.model.commands;

import com.microservice.daily.activities.domain.model.aggregates.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record CreateDailyActivityCommand(Long projectId, String description, LocalDate date, List<Task> tasks) {
    public CreateDailyActivityCommand {
        Objects.requireNonNull(projectId, "projectId must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(date, "date must not be null");
        Objects.requireNonNull(tasks, "tasks must not be null");
    }
}
