package com.microservuce.daily_activites.Interface.rest.transform;

import com.microservuce.daily_activites.Interface.rest.resources.CreateDailyActivityResource;
import com.microservuce.daily_activites.domain.model.commands.CreateDailyActivityCommand;

public class CreateDailyActivityCommandFromResourceAssembler {
    public static CreateDailyActivityCommand toCommandFromResource(CreateDailyActivityResource resource) {
        return new CreateDailyActivityCommand(
                resource.description(),
                resource.name(),
                resource.projectId(),
                resource.image(),
                resource.status()
        );
    }
}
