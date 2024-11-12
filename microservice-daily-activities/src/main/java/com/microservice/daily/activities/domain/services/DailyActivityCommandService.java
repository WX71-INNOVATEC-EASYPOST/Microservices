package com.microservice.daily.activities.domain.services;

import com.microservice.daily.activities.domain.model.aggregates.DailyActivity;
import com.microservice.daily.activities.domain.model.commands.CreateDailyActivityCommand;

import java.util.Optional;

public interface DailyActivityCommandService {
    Optional<DailyActivity> handle(CreateDailyActivityCommand command);
}
