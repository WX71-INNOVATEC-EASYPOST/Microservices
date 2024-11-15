package com.microservice.materials.domain.services;

import com.microservice.materials.domain.model.commands.CreateMaterialCommand;
import com.microservice.materials.domain.model.commands.DeleteMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateMaterialCommand;
import com.microservice.materials.domain.model.entity.Materials;

import java.util.Optional;

public interface MaterialCommandService {
    Optional<Materials> handle(CreateMaterialCommand command);
    Optional<Materials> handle(UpdateMaterialCommand command);
    void handle(DeleteMaterialCommand command);
}
