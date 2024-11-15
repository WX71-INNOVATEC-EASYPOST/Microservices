package com.microservice.materials.Interface.rest.resources;

public record MaterialResource(
        String name,
        String description,
        double cost
) {
}
