package com.microservice.project.domain.model.commands;

import com.microservice.project.domain.model.entity.Project;

import java.util.List;

public record CreateLocationCommand(
        String department,
        String province,
        String district,
        String locality,
        String address,
        String reference,
        List<Project> projects,
        Long requestId
){
    public CreateLocationCommand {
        if (department == null || department.isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        if (province == null || province.isEmpty()) {
            throw new IllegalArgumentException("Province cannot be empty");
        }
        if (district == null || district.isEmpty()) {
            throw new IllegalArgumentException("District cannot be empty");
        }
        if (locality == null || locality.isEmpty()) {
            throw new IllegalArgumentException("Locality cannot be empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (reference == null || reference.isEmpty()) {
            throw new IllegalArgumentException("Reference cannot be empty");
        }
        if (projects == null || projects.isEmpty()) {
            throw new IllegalArgumentException("Projects cannot be empty");
        }
        if (requestId == null || requestId < 0) {
            throw new IllegalArgumentException("RequestId cannot be empty");
        }
    }
}
