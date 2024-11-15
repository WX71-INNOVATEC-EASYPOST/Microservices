package com.microservice.materials.domain.model.queries;

public record GetMaterialsByNameQuery(String name) {
    public GetMaterialsByNameQuery {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
    }
}
