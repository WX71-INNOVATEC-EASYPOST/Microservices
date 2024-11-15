package com.microservice.materials.application.internal.commandservices;

import com.microservice.materials.domain.model.commands.CreateMaterialCommand;
import com.microservice.materials.domain.model.commands.DeleteMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateMaterialCommand;
import com.microservice.materials.domain.model.entity.Materials;
import com.microservice.materials.domain.services.MaterialCommandService;
import com.microservice.materials.infrastructure.persistence.jpa.repositories.MaterialsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialCommandServiceImpl implements MaterialCommandService {
    private final MaterialsRepository materialsRepository;
    public MaterialCommandServiceImpl(MaterialsRepository materialsRepository) {
        this.materialsRepository = materialsRepository;
    }

    @Override
    public Optional<Materials> handle(CreateMaterialCommand command) {
        var material = new Materials(command);
        var createdMaterial = materialsRepository.save(material);
        return Optional.of(createdMaterial);
    }

    @Override
    public Optional<Materials> handle(UpdateMaterialCommand command) {
        var result = materialsRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Material not found");

        var materialToUpdate = result.get();
        try {
            materialToUpdate.updateMaterial(command);
            var updatedMaterial = materialsRepository.save(materialToUpdate);
            return Optional.of(updatedMaterial);
        } catch (Exception e) {
            throw new IllegalArgumentException("Material not found");
        }
    }

    @Override
    public void handle(DeleteMaterialCommand command) {
        if (!materialsRepository.existsById(command.id())) throw new IllegalArgumentException("Material not found");
        try {
            materialsRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error deleting material");
        }
    }
}
