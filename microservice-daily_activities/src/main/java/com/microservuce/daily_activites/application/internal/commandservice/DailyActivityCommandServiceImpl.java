package com.microservuce.daily_activites.application.internal.commandservice;

import com.microservuce.daily_activites.domain.model.commands.CreateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.commands.DeleteDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.commands.UpdateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.entity.DailyActivity;
import com.microservuce.daily_activites.domain.services.DailyActivityCommandService;
import com.microservuce.daily_activites.infrastructure.persistence.jpa.repositories.DailyActivityRepository;
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

    @Override
    public Optional<DailyActivity> handle(UpdateDailyActivityCommand command) {
        var result = dailyActivityRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Daily activity not found");

        var dailyActivityToUpdate = result.get();
        try{
            dailyActivityToUpdate.updateDailyActivity(command);
            var updatedDailyActivity = dailyActivityRepository.save(dailyActivityToUpdate);
            return Optional.of(updatedDailyActivity);
        } catch (Exception e){
            throw new IllegalArgumentException("Update daily activity failed");
        }
    }

    @Override
    public void handle(DeleteDailyActivityCommand command) {
        if(!dailyActivityRepository.existsById(command.id())) throw new IllegalArgumentException("Daily activity not found");
        try {
            dailyActivityRepository.deleteById(command.id());
        } catch (Exception e){
            throw new IllegalArgumentException("Delete daily activity failed");
        }
    }
}
