package com.microservice.daily.activities.application.internal.commandservices;

import com.microservice.daily.activities.domain.model.aggregates.DailyActivity;
import com.microservice.daily.activities.domain.model.commands.CreateDailyActivityCommand;
import com.microservice.daily.activities.domain.services.DailyActivityCommandService;
import com.microservice.daily.activities.infrastructure.persistence.jpa.repositories.DailyActivityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DailyActivityCommandServiceImpl implements DailyActivityCommandService {

    private final DailyActivityRepository dailyActivityRepository;

    public DailyActivityCommandServiceImpl(DailyActivityRepository dailyActivityRepository) {
        this.dailyActivityRepository = dailyActivityRepository;
    }

    @Override
    public Optional<DailyActivity> handle(CreateDailyActivityCommand command) {
        var dailyActivity = new DailyActivity(command);
        var createdDailyActivity = dailyActivityRepository.save(dailyActivity);
        return Optional.of(createdDailyActivity);
    }
}
