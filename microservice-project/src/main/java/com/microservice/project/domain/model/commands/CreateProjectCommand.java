package com.microservice.project.domain.model.commands;

import com.microservice.project.domain.model.aggregates.Location;

import java.util.List;

public record CreateProjectCommand(
        String title,
        String accessCode,
        Long companyProfileId,
        Long totalBudget,
        Long partialBudget,
        Long locationId,
        List<Long> projectMaterialIds,
        Long requestId
) {
    public CreateProjectCommand {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        if (accessCode == null || accessCode.isEmpty()) {
            throw new IllegalArgumentException("accessCode cannot be null or empty");
        }
        if (companyProfileId == null || companyProfileId < 0) {
            throw new IllegalArgumentException("companyProfileId cannot be null or negative");
        }
        if (totalBudget == null || totalBudget < 0) {
            throw new IllegalArgumentException("totalBudget cannot be null or negative");
        }
        if (partialBudget == null || partialBudget < 0) {
            throw new IllegalArgumentException("partialBudget cannot be null or negative");
        }
        if (locationId == null || locationId < 0) {
            throw new IllegalArgumentException("locationId cannot be null or negative");
        }
        if (projectMaterialIds == null || projectMaterialIds.isEmpty()) {
            throw new IllegalArgumentException("projectMaterialIds cannot be null or empty");
        }
        if (requestId == null || requestId < 0) {
            throw new IllegalArgumentException("requestId cannot be null or negative");
        }
    }
}
