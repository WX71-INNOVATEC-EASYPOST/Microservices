package com.microservice.materials.infrastructure.persistence.jpa.repositories;

import com.microservice.materials.domain.model.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {
    boolean existsMaterialsById(Long id);
    Materials findMaterialsByName(String name);
}
