package com.microservuce.daily_activites.Interface.rest.transform;

import com.microservuce.daily_activites.Interface.rest.resources.DailyActivityResource;
import com.microservuce.daily_activites.domain.model.entity.DailyActivity;

public class DailyActivityFromEntityAssembler {
    public static DailyActivityResource toResourceFromEntity(DailyActivity dailyActivity) {
        return new DailyActivityResource(
                dailyActivity.getDescription(),
                dailyActivity.getName(),
                dailyActivity.getProjectId(),
                dailyActivity.getImage(),
                dailyActivity.getStatus()
        );
    }
}
