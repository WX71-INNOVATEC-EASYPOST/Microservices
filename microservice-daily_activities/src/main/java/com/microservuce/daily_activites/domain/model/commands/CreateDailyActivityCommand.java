package com.microservuce.daily_activites.domain.model.commands;

import com.microservuce.daily_activites.domain.model.valuobjects.Status;

public record CreateDailyActivityCommand(
        String description,
        String name,
        Long projectId,
        String image,
        Status status
) {
    public CreateDailyActivityCommand {
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if(projectId == null || projectId < 0){
            throw new IllegalArgumentException("projectId cannot be null or negative");
        }
        if(image == null || image.isEmpty()){
            throw new IllegalArgumentException("image cannot be null or empty");
        }
        if(status == null){
            throw new IllegalArgumentException("status cannot be null");
        }
    }
}
