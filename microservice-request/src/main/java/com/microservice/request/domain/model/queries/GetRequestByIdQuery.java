package com.microservice.request.domain.model.queries;

public record GetRequestByIdQuery(Long id) {
    public GetRequestByIdQuery{
        if (id == null || id < 0) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }
}
