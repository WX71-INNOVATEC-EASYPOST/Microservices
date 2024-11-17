package com.microservice.materials.domain.model.queries;

public record GetProjectMaterialsByProjectIdAndMaterialIdQuery(Long projectId, Long materialId) {
    public GetProjectMaterialsByProjectIdAndMaterialIdQuery {
        if (projectId == null || projectId <= 0 ){
            throw new IllegalArgumentException("projectId must be greater than 0");
        }
        if (materialId == null || materialId <= 0 ){
            throw new IllegalArgumentException("materialId must be greater than 0");
        }
    }
}
