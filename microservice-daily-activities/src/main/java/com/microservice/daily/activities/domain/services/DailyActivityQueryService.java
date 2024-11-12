package com.microservice.daily.activities.domain.services;

import com.microservice.daily.activities.domain.model.aggregates.DailyActivity;
import com.microservice.daily.activities.domain.model.queries.GetAllDailyActivitiesQuery;
import com.microservice.daily.activities.domain.model.queries.GetDailyActivityByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DailyActivityQueryService {
    List<DailyActivity> handle(GetAllDailyActivitiesQuery query);
    Optional<DailyActivity> handle(GetDailyActivityByIdQuery query);
}
