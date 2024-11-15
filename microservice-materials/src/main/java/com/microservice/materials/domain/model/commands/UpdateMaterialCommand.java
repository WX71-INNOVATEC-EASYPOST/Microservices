package com.microservice.materials.domain.model.commands;

public record UpdateMaterialCommand(
        Long id,
        String name,
        String description,
        double cost
) {
    public UpdateMaterialCommand {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        if(description == null || description.isEmpty()) {
            throw new IllegalArgumentException("description cannot be empty");
        }
        if(cost < 0) {
            throw new IllegalArgumentException("cost cannot be negative");
        }
    }
}
