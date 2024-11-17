package com.microservuce.daily_activites.Interface.rest.transform;

import com.microservuce.daily_activites.domain.model.commands.UpdateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.valuobjects.Status;

public class UpdateDailyActivityCommandFromResourceAssembler {
    public static UpdateDailyActivityCommand toCommandFromResource(
            Long id,
            String description,
            String name,
            Long projectId,
            String image,
            Status status
    ){
        return new UpdateDailyActivityCommand(id, description, name, projectId, image, status);
    }
}
