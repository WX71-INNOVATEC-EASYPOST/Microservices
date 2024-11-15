package com.microservice.materials.Interface.rest.transform;

import com.microservice.materials.domain.model.commands.UpdateMaterialCommand;

public class UpdateMaterialCommandFromResourceAssembler {
    public static UpdateMaterialCommand toCommandFromResource(
            Long id,
            String name,
            String description,
            double cost
    ){
        return new UpdateMaterialCommand(id, name, description, cost);
    }
}
