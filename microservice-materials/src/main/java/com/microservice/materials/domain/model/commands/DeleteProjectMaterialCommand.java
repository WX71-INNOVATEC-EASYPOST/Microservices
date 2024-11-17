package com.microservice.materials.domain.model.commands;

public record DeleteProjectMaterialCommand(Long id) {
    public DeleteProjectMaterialCommand {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}

