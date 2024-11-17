package com.microservuce.daily_activites.domain.model.queries;

public record GetAllDailyActivitiesByProjectIdQuery(Long projectId) {
    public GetAllDailyActivitiesByProjectIdQuery {
        if (projectId == null || projectId < 0) {
            throw new IllegalArgumentException("projectId cannot be null or negative");
        }
    }
}
