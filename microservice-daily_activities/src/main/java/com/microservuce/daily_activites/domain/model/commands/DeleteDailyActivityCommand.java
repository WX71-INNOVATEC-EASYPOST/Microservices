package com.microservuce.daily_activites.domain.model.commands;

public record DeleteDailyActivityCommand(Long id) {
    public DeleteDailyActivityCommand {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("id is invalid");
        }
    }
}
