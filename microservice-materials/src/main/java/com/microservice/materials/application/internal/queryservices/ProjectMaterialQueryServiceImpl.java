package com.microservice.materials.application.internal.queryservices;

import com.microservice.materials.domain.model.aggregates.ProjectMaterials;
import com.microservice.materials.domain.model.queries.GetAllProjectMaterialsByProjectIdQuery;
import com.microservice.materials.domain.model.queries.GetProjectMaterialsByProjectIdAndMaterialIdQuery;
import com.microservice.materials.domain.services.ProjectMaterialQueryService;
import com.microservice.materials.infrastructure.persistence.jpa.repositories.ProjectMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectMaterialQueryServiceImpl implements ProjectMaterialQueryService {
    private final ProjectMaterialRepository projectMaterialRepository;
    public ProjectMaterialQueryServiceImpl(ProjectMaterialRepository projectMaterialRepository) {
        this.projectMaterialRepository = projectMaterialRepository;
    }

    @Override
    public List<ProjectMaterials> handle(GetAllProjectMaterialsByProjectIdQuery query) {
        return List.of(projectMaterialRepository.findByProjectId(query.projectId()));
    }

    @Override
    public Optional<ProjectMaterials> handle(GetProjectMaterialsByProjectIdAndMaterialIdQuery query) {
        return Optional.of(projectMaterialRepository.findByProjectIdAndMaterialId(query.projectId(), query.materialId()));
    }
}
