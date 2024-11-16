package com.microservice.materials.Interface.rest.transform;

import com.microservice.materials.Interface.rest.resources.ProjectMaterialResource;
import com.microservice.materials.domain.model.aggregates.ProjectMaterials;

public class ProjectMaterialResourceFromEntityAssembler {
    public static ProjectMaterialResource toResourceFromEntity(ProjectMaterials projectMaterials) {
        return new ProjectMaterialResource(
                projectMaterials.getProjectId(),
                projectMaterials.getMaterialId(),
                projectMaterials.getAmount()
        );
    }
}
