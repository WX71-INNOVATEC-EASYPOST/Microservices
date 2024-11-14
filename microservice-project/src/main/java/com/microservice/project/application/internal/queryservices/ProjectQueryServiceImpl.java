package com.microservice.project.application.internal.queryservices;

import com.microservice.project.domain.model.entity.Project;
import com.microservice.project.domain.model.queries.GetAllProjectsQuery;
import com.microservice.project.domain.model.queries.GetProjectByIdQuery;
import com.microservice.project.domain.model.queries.GetProjectByLocationIdQuery;
import com.microservice.project.domain.services.ProjectQueryService;
import com.microservice.project.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectQueryServiceImpl implements ProjectQueryService {
    private final ProjectRepository projectRepository;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> handle(GetAllProjectsQuery query) {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> handle(GetProjectByIdQuery query) {
        return projectRepository.findById(query.id());
    }

    @Override
    public Optional<Project> handle(GetProjectByLocationIdQuery query) {
        return Optional.of(projectRepository.findByLocationId(query.locationId()));
    }
}
