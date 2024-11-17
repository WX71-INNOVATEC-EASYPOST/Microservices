package com.microservice.materials.Interface.rest.resources;

public record UpdateProjectMaterialResource(
        Long id,
        Long projectId,
        Long materialId,
        double amount
) {
    public UpdateProjectMaterialResource {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("id must be greater than 0");
        }
        if (projectId == null || projectId <= 0) {
            throw new IllegalArgumentException("projectId must be greater than 0");
        }
        if (materialId == null || materialId <= 0) {
            throw new IllegalArgumentException("materialId must be greater than 0");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be greater than 0");
        }
    }
}
