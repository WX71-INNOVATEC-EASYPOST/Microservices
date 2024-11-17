package com.microservice.materials.Interface.rest.transform;

import com.microservice.materials.domain.model.commands.UpdateProjectMaterialCommand;

public class UpdateProjectMaterialCommandFromResourceAssembler {
    public static UpdateProjectMaterialCommand toCommandFromResource(
            Long id,
            Long projectId,
            Long materialId,
            double amount
    ) {
        return new UpdateProjectMaterialCommand(id, projectId, materialId, amount);
    }
}
