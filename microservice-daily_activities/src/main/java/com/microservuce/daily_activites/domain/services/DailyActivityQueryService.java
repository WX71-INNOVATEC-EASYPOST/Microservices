package com.microservuce.daily_activites.domain.services;

import com.microservuce.daily_activites.domain.model.entity.DailyActivity;
import com.microservuce.daily_activites.domain.model.queries.GetAllDailyActivitiesByProjectIdQuery;
import com.microservuce.daily_activites.domain.model.queries.GetAllDailyActivitiesQuery;
import com.microservuce.daily_activites.domain.model.queries.GetDailyActivityByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DailyActivityQueryService {
    List<DailyActivity> handle(GetAllDailyActivitiesQuery query);
    List<DailyActivity> handle(GetAllDailyActivitiesByProjectIdQuery query);
    Optional<DailyActivity> handle(GetDailyActivityByIdQuery query);
}
