package com.microservuce.daily_activites.domain.services;

import com.microservuce.daily_activites.domain.model.commands.CreateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.commands.DeleteDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.commands.UpdateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.entity.DailyActivity;

import java.util.Optional;

public interface DailyActivityCommandService {
    Optional<DailyActivity> handle(CreateDailyActivityCommand command);
    Optional<DailyActivity> handle(UpdateDailyActivityCommand command);
    void handle(DeleteDailyActivityCommand command);
}
