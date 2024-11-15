package com.microservice.materials.domain.model.commands;

public record CreateMaterialCommand(
        String name,
        String description,
        double cost
) {
    public CreateMaterialCommand {
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
