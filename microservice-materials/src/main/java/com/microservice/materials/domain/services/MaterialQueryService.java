package com.microservice.materials.domain.services;

import com.microservice.materials.domain.model.entity.Materials;
import com.microservice.materials.domain.model.queries.GetAllMaterialsQuery;
import com.microservice.materials.domain.model.queries.GetMaterialsByIdQuery;
import com.microservice.materials.domain.model.queries.GetMaterialsByNameQuery;

import java.util.List;
import java.util.Optional;

public interface MaterialQueryService {
    List<Materials> handle(GetAllMaterialsQuery query);
    Optional<Materials> handle(GetMaterialsByIdQuery query);
    Optional<Materials> handle(GetMaterialsByNameQuery query);
}
