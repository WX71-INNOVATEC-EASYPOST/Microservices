package com.microservice.daily.activities.application.internal.queryservices;

import com.microservice.daily.activities.domain.model.aggregates.DailyActivity;
import com.microservice.daily.activities.domain.model.queries.GetAllDailyActivitiesQuery;
import com.microservice.daily.activities.domain.model.queries.GetDailyActivityByIdQuery;
import com.microservice.daily.activities.domain.services.DailyActivityQueryService;
import com.microservice.daily.activities.infrastructure.persistence.jpa.repositories.DailyActivityRepository;
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
    public List<DailyActivity> handle(GetAllDailyActivitiesQuery query){
        return dailyActivityRepository.findAll();
    }

    @Override
    public Optional<DailyActivity> handle(GetDailyActivityByIdQuery query) {
        return dailyActivityRepository.findById(query.id());
    }
}
