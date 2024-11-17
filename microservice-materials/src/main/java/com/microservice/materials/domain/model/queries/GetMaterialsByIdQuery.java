package com.microservice.materials.domain.model.queries;

public record GetMaterialsByIdQuery(Long id) {
    public GetMaterialsByIdQuery {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("id cannot be null or negative");
        }
    }
}
