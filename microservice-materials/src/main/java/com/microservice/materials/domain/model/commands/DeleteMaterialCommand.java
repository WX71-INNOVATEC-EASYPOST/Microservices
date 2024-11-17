package com.microservice.materials.domain.model.commands;

public record DeleteMaterialCommand(Long id) {
    public DeleteMaterialCommand {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
