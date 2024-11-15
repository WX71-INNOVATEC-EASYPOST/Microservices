package com.microservice.materials.Interface.rest.resources;

public record CreateMaterialResource(
        String name,
        String description,
        double cost
) {
    public CreateMaterialResource {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be null or empty");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("cost cannot be negative");
        }
    }
}
