package com.microservice.project.Interface.rest.resources;

import java.util.List;

public record CreateProjectResource (
        String title,
        String accessCode,
        Long companyProfileId,
        Long totalBudget,
        Long partialBudget,
        Long locationId,
        List<Long> projectMaterialsIds,
        Long requestId
) {
    public CreateProjectResource{
        if(title == null){
            throw new IllegalArgumentException("title cannot be null");
        }
        if (accessCode == null){
            throw new IllegalArgumentException("accessCode cannot be null");
        }
        if (companyProfileId == null){
            throw new IllegalArgumentException("companyProfileId cannot be null");
        }
        if (totalBudget == null){
            throw new IllegalArgumentException("totalBudget cannot be null");
        }
        if (partialBudget == null){
            throw new IllegalArgumentException("partialBudget cannot be null");
        }
        if (locationId == null){
            throw new IllegalArgumentException("locationId cannot be null");
        }
        if (projectMaterialsIds == null){
            throw new IllegalArgumentException("projectMaterialsIds cannot be null");
        }
        if (requestId == null){
            throw new IllegalArgumentException("requestId cannot be null");
        }
    }
}