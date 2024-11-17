package com.microservuce.daily_activites.Interface.rest.resources;

import com.microservuce.daily_activites.domain.model.valuobjects.Status;

public record DailyActivityResource(
        String description,
        String name,
        Long projectId,
        String image,
        Status status
) {
}
