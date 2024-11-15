package com.microservice.materials.Interface.rest.transform;

import com.microservice.materials.Interface.rest.resources.MaterialResource;
import com.microservice.materials.domain.model.entity.Materials;

public class MaterialResourceFromEntityAssembler {
    public static MaterialResource toResourceFromEntity(Materials materials) {
        return new MaterialResource(
                materials.getName(),
                materials.getDescription(),
                materials.getCost()
        );
    }
}
