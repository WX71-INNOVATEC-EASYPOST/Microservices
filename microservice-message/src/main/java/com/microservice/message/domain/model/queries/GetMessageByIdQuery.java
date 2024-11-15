package com.microservice.message.domain.model.queries;

public record GetMessageByIdQuery(Long id) {
    public GetMessageByIdQuery {
        if (id == null || id == 0){
            throw new IllegalArgumentException("id cannot be null or empty");
        }
    }
}
