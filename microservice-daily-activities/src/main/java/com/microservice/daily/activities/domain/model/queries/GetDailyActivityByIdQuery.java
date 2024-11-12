package com.microservice.daily.activities.domain.model.queries;

public record GetDailyActivityByIdQuery(Long id) {
    public GetDailyActivityByIdQuery {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
