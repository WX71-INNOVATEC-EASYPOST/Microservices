package com.example.MaterialsService.easypost.service;

import com.example.MaterialsService.easypost.model.ProjectMaterials;

import java.util.List;

public interface ProjectMaterialsService {
    ProjectMaterials createProjectMaterials(ProjectMaterials projectMaterials);
    List<ProjectMaterials> getProjectMaterialsByProjectId(Long projectId);
    ProjectMaterials getProjectMaterialsByProjectIdAndMaterialId(Long projectId, Long materialId);
    ProjectMaterials updateProjectMaterials(Long id, ProjectMaterials projectMaterialsDetails);
    void deleteProjectMaterials(Long id);
}
