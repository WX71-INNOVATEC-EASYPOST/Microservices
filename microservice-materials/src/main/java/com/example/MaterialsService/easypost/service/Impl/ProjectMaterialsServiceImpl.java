package com.example.MaterialsService.easypost.service.Impl;

import com.example.MaterialsService.easypost.model.ProjectMaterials;
import com.example.MaterialsService.easypost.repository.ProjectMaterialRepository;
import com.example.MaterialsService.easypost.service.ProjectMaterialsService;
import com.example.MaterialsService.shared.exception.ResourceNotFoundException;
import com.example.MaterialsService.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProjectMaterialsServiceImpl implements ProjectMaterialsService {
    @Autowired
    private ProjectMaterialRepository projectMaterialRepository;

    @Override
    public ProjectMaterials createProjectMaterials(ProjectMaterials projectMaterials) {
        existsProjectMaterialById(projectMaterials);
        return projectMaterialRepository.save(projectMaterials);
    }

    @Override
    public List<ProjectMaterials> getProjectMaterialsByProjectId(Long projectId) {
        return Collections.singletonList(projectMaterialRepository.findByProjectId(projectId));
    }

    @Override
    public ProjectMaterials getProjectMaterialsByProjectIdAndMaterialId(Long projectId, Long materialId) {
        ProjectMaterials projectMaterials = projectMaterialRepository.findByProjectIdAndMaterialId(projectId, materialId);
        if (projectMaterials == null) {
            throw new ResourceNotFoundException("Project material not found with projectId " + projectId + " and materialId " + materialId);
        }
        return projectMaterials;
    }

    @Override
    public ProjectMaterials updateProjectMaterials(Long id, ProjectMaterials projectMaterialsDetails) {
        ProjectMaterials projectMaterials = projectMaterialRepository.findProjectMaterialsById(id);
        if (projectMaterials == null) {
            throw new ResourceNotFoundException("Project material not found with id " + id);
        }

        projectMaterials.setProjectId(projectMaterialsDetails.getProjectId());
        projectMaterials.setMaterialId(projectMaterialsDetails.getMaterialId());
        projectMaterials.setAmount(projectMaterialsDetails.getAmount());

        return projectMaterialRepository.save(projectMaterials);
    }

    @Override
    public void deleteProjectMaterials(Long id) {
        ProjectMaterials projectMaterials = projectMaterialRepository.findProjectMaterialsById(id);
        if (projectMaterials == null) {
            throw new ResourceNotFoundException("Project material not found with id " + id);
        }
        projectMaterialRepository.delete(projectMaterials);
    }

    private void existsProjectMaterialById(ProjectMaterials projectMaterials) {
        if (projectMaterialRepository.existsById(projectMaterials.getId())) {
            throw new ValidationException("Project Material already exists");
        }
    }
}
