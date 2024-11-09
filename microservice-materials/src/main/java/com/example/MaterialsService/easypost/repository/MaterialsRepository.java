package com.example.MaterialsService.easypost.repository;

import com.example.MaterialsService.easypost.model.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {
    boolean existsMaterialsById(Long id);
    Materials findMaterialsByName(String name);
}
