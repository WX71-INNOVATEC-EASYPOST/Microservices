package com.microservice.request.Interface.rest.resources;

public record UpdateRequestStatusResource(String status) {
    public UpdateRequestStatusResource {
        if (status == null) {
            throw new IllegalArgumentException("status is required");
        }
    }
}