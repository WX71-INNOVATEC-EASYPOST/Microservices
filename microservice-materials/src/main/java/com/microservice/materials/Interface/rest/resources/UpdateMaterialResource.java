package com.microservice.materials.Interface.rest.resources;

public record UpdateMaterialResource(
        Long id,
        String name,
        String description,
        double cost
) {
    public UpdateMaterialResource {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be empty");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("cost cannot be negative");
        }
    }
}
