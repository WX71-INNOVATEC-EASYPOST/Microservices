package com.microservice.project.domain.services;

import com.microservice.project.domain.model.entity.Project;
import com.microservice.project.domain.model.queries.GetAllProjectsQuery;
import com.microservice.project.domain.model.queries.GetProjectByIdQuery;
import com.microservice.project.domain.model.queries.GetProjectByLocationIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryService {
    List<Project> handle(GetAllProjectsQuery query);
    Optional<Project> handle(GetProjectByIdQuery query);
    Optional<Project> handle(GetProjectByLocationIdQuery query);
}
