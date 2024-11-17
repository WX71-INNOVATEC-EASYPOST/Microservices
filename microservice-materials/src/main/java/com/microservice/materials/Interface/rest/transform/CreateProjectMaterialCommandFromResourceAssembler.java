package com.microservice.materials.Interface.rest.transform;

import com.microservice.materials.Interface.rest.resources.CreateProjectMaterialResource;
import com.microservice.materials.domain.model.commands.CreateProjectMaterialCommand;

public class CreateProjectMaterialCommandFromResourceAssembler {
    public static CreateProjectMaterialCommand toCommandFromResource(CreateProjectMaterialResource createProjectMaterialResource) {
        return new CreateProjectMaterialCommand(
                createProjectMaterialResource.projectId(),
                createProjectMaterialResource.materialId(),
                createProjectMaterialResource.amount()
        );
    }
}
