package com.example.MaterialsService.easypost.repository;

import com.example.MaterialsService.easypost.model.ProjectMaterials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMaterialRepository extends JpaRepository<ProjectMaterials, Long> {
    boolean existsById(Long id);
    ProjectMaterials findProjectMaterialsById(Long id);
    ProjectMaterials findByProjectId(Long projectId);
    ProjectMaterials findByProjectIdAndMaterialId(Long projectId, Long materialId);
}
