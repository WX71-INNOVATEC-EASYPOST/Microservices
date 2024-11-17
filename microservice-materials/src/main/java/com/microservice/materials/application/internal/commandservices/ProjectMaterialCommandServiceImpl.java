package com.microservice.materials.application.internal.commandservices;

import com.microservice.materials.domain.model.aggregates.ProjectMaterials;
import com.microservice.materials.domain.model.commands.CreateProjectMaterialCommand;
import com.microservice.materials.domain.model.commands.DeleteProjectMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateProjectMaterialCommand;
import com.microservice.materials.domain.services.ProjectMaterialCommandService;
import com.microservice.materials.infrastructure.persistence.jpa.repositories.MaterialsRepository;
import com.microservice.materials.infrastructure.persistence.jpa.repositories.ProjectMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectMaterialCommandServiceImpl implements ProjectMaterialCommandService {
    private final ProjectMaterialRepository projectMaterialRepository;

    public ProjectMaterialCommandServiceImpl(ProjectMaterialRepository projectMaterialRepository, MaterialsRepository materialsRepository) {
        this.projectMaterialRepository = projectMaterialRepository;
    }

    @Override
    public Optional<ProjectMaterials> handle(CreateProjectMaterialCommand command) {
        var projectMaterial = new ProjectMaterials(command);
        var createdProjectMaterial = projectMaterialRepository.save(projectMaterial);
        return Optional.of(createdProjectMaterial);
    }

    @Override
    public Optional<ProjectMaterials> handle(UpdateProjectMaterialCommand command) {
        var result = projectMaterialRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Project material not found");

        var projectMaterialToUpdate = result.get();
        try {
            projectMaterialToUpdate.updateProjectMaterial(command);
            var updatedProjectMaterial = projectMaterialRepository.save(projectMaterialToUpdate);
            return Optional.of(updatedProjectMaterial);
        } catch (Exception e){
            throw new IllegalArgumentException("Project material not found");
        }
    }

    @Override
    public void handle(DeleteProjectMaterialCommand command) {
        if (!projectMaterialRepository.existsById(command.id())) throw new IllegalArgumentException("Project material not found");
        try {
            projectMaterialRepository.deleteById(command.id());
        } catch (Exception e){
            throw new IllegalArgumentException("Project material not found");
        }
    }
}
