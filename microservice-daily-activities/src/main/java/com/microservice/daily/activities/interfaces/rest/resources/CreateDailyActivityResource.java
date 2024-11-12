package com.microservice.daily.activities.interfaces.rest.resources;

import java.util.Objects;

public record CreateDailyActivityResource(Long projectId, String description, String date, List<TaskResource> tasks) {
    public CreateDailyActivityResource {
        Objects.requireNonNull(projectId, "projectId must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(date, "date must not be null");
        Objects.requireNonNull(tasks, "tasks must not be null");
    }
}
