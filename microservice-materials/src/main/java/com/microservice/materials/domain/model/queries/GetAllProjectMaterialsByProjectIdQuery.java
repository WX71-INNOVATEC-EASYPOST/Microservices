package com.microservice.materials.domain.model.queries;

public record GetAllProjectMaterialsByProjectIdQuery(Long projectId) {
    public  GetAllProjectMaterialsByProjectIdQuery {
        if (projectId == null || projectId <= 0) {
            throw new IllegalArgumentException("projectId must be greater than 0");
        }
    }
}
