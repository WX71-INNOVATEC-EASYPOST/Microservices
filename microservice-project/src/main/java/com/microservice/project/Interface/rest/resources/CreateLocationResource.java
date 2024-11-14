package com.microservice.project.Interface.rest.resources;

import com.microservice.project.domain.model.entity.Project;

import java.util.List;

public record CreateLocationResource(
        String department,
        String province,
        String district,
        String locality,
        String address,
        String reference,
        List<Project> projects,
        Long requestId
) {
    public CreateLocationResource {
        if (department == null) {
            throw new IllegalArgumentException("department cannot be null");
        }
        if (province == null) {
            throw new IllegalArgumentException("province cannot be null");
        }
        if (district == null) {
            throw new IllegalArgumentException("district cannot be null");
        }
        if (locality == null) {
            throw new IllegalArgumentException("locality cannot be null");
        }
        if (address == null) {
            throw new IllegalArgumentException("address cannot be null");
        }
        if (reference == null) {
            throw new IllegalArgumentException("reference cannot be null");
        }
        if (projects == null) {
            throw new IllegalArgumentException("projects cannot be null");
        }
        if (requestId == null) {
            throw new IllegalArgumentException("requestId cannot be null");
        }
    }
}
