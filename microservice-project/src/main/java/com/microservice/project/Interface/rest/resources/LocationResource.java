package com.microservice.project.Interface.rest.resources;

import com.microservice.project.domain.model.entity.Project;

import java.util.List;

public record LocationResource(
        String department,
        String province,
        String district,
        String locality,
        String address,
        String reference,
        List<Project> projects,
        Long requestId
) {
}
