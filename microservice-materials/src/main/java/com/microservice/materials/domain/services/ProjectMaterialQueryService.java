package com.microservice.materials.domain.services;

import com.microservice.materials.domain.model.aggregates.ProjectMaterials;
import com.microservice.materials.domain.model.queries.GetAllProjectMaterialsByProjectIdQuery;
import com.microservice.materials.domain.model.queries.GetProjectMaterialsByProjectIdAndMaterialIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProjectMaterialQueryService {
    List<ProjectMaterials> handle(GetAllProjectMaterialsByProjectIdQuery query);
    Optional<ProjectMaterials> handle(GetProjectMaterialsByProjectIdAndMaterialIdQuery query);
}
