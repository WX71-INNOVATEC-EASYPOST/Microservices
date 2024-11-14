package com.microservice.project.domain.services;

import com.microservice.project.domain.model.commands.CreateProjectCommand;
import com.microservice.project.domain.model.entity.Project;

import java.util.Optional;

public interface ProjectCommandService {
    Optional<Project> handle(CreateProjectCommand command);
}
