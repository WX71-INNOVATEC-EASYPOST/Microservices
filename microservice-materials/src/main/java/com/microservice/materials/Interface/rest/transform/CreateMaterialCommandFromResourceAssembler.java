package com.microservice.materials.Interface.rest.transform;

import com.microservice.materials.Interface.rest.resources.CreateMaterialResource;
import com.microservice.materials.domain.model.commands.CreateMaterialCommand;

public class CreateMaterialCommandFromResourceAssembler {
    public static CreateMaterialCommand toCommandFromResource(CreateMaterialResource createMaterialResource) {
        return  new CreateMaterialCommand(
                createMaterialResource.name(),
                createMaterialResource.description(),
                createMaterialResource.cost()
        );
    }
}
