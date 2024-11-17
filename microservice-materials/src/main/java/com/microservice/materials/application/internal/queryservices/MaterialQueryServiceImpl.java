package com.microservice.materials.application.internal.queryservices;

import com.microservice.materials.domain.model.entity.Materials;
import com.microservice.materials.domain.model.queries.GetAllMaterialsQuery;
import com.microservice.materials.domain.model.queries.GetMaterialsByIdQuery;
import com.microservice.materials.domain.model.queries.GetMaterialsByNameQuery;
import com.microservice.materials.domain.services.MaterialQueryService;
import com.microservice.materials.infrastructure.persistence.jpa.repositories.MaterialsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialQueryServiceImpl implements MaterialQueryService {
    private final MaterialsRepository materialsRepository;
    public MaterialQueryServiceImpl(final MaterialsRepository materialsRepository) {
        this.materialsRepository = materialsRepository;
    }

    @Override
    public List<Materials> handle(GetAllMaterialsQuery query) {
        return materialsRepository.findAll();
    }

    @Override
    public Optional<Materials> handle(GetMaterialsByIdQuery query) {
        return materialsRepository.findById(query.id());
    }

    @Override
    public Optional<Materials> handle(GetMaterialsByNameQuery query) {
        return Optional.of(materialsRepository.findMaterialsByName(query.name()));
    }
}
