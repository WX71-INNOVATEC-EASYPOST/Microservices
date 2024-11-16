package com.microservice.materials.Interface.rest.resources;

public record ProjectMaterialResource(
        Long projectId,
        Long materialId,
        double amount
) {
}
