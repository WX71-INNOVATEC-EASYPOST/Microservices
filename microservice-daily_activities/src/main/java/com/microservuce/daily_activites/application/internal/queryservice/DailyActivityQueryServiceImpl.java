package com.microservuce.daily_activites.application.internal.queryservice;

import com.microservuce.daily_activites.domain.model.entity.DailyActivity;
import com.microservuce.daily_activites.domain.model.queries.GetAllDailyActivitiesByProjectIdQuery;
import com.microservuce.daily_activites.domain.model.queries.GetAllDailyActivitiesQuery;
import com.microservuce.daily_activites.domain.model.queries.GetDailyActivityByIdQuery;
import com.microservuce.daily_activites.domain.services.DailyActivityQueryService;
import com.microservuce.daily_activites.infrastructure.persistence.jpa.repositories.DailyActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyActivityQueryServiceImpl implements DailyActivityQueryService {
    private final DailyActivityRepository dailyActivityRepository;
    public DailyActivityQueryServiceImpl(DailyActivityRepository dailyActivityRepository) {
        this.dailyActivityRepository = dailyActivityRepository;
    }


    @Override
    public List<DailyActivity> handle(GetAllDailyActivitiesQuery query) {
        return dailyActivityRepository.findAll();
    }

    @Override
    public List<DailyActivity> handle(GetAllDailyActivitiesByProjectIdQuery query) {
        return dailyActivityRepository.findAllByProjectId(query.projectId());
    }

    @Override
    public Optional<DailyActivity> handle(GetDailyActivityByIdQuery query) {
        return dailyActivityRepository.findById(query.id());
    }
}
