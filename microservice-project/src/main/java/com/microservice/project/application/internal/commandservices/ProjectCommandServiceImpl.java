package com.microservice.project.application.internal.commandservices;

import com.microservice.project.domain.model.commands.CreateProjectCommand;
import com.microservice.project.domain.model.entity.Project;
import com.microservice.project.domain.services.ProjectCommandService;
import com.microservice.project.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {
    private final ProjectRepository projectRepository;

    public ProjectCommandServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> handle(CreateProjectCommand command) {
        var project = new Project(command);
        var createdProject = projectRepository.save(project);
        return Optional.of(createdProject);
    }
}
