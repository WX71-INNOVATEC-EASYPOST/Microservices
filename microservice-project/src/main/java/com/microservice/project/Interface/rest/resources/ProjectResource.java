package com.microservice.project.Interface.rest.resources;

import java.util.List;

public record ProjectResource(
        String title,
        String accessCode,
        Long companyProfileId,
        Long totalBudget,
        Long partialBudget,
        Long locationId,
        List<Long> projectMaterialsIds,
        Long requestId
) {
}
