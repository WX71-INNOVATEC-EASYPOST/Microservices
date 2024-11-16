package com.microservice.materials.domain.services;

import com.microservice.materials.domain.model.aggregates.ProjectMaterials;
import com.microservice.materials.domain.model.commands.CreateProjectMaterialCommand;
import com.microservice.materials.domain.model.commands.DeleteProjectMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateProjectMaterialCommand;

import java.util.Optional;

public interface ProjectMaterialCommandService {
    Optional<ProjectMaterials> handle(CreateProjectMaterialCommand command);
    Optional<ProjectMaterials> handle(UpdateProjectMaterialCommand command);
    void handle(DeleteProjectMaterialCommand command);
}
