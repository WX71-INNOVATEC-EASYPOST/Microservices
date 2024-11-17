package com.microservuce.daily_activites.domain.model.queries;

public record GetDailyActivityByIdQuery(Long id) {
    public GetDailyActivityByIdQuery {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("id is invalid");
        }
    }
}
