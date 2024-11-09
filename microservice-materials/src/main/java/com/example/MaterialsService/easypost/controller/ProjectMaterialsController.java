package com.example.MaterialsService.easypost.controller;

import com.example.MaterialsService.easypost.model.ProjectMaterials;
import com.example.MaterialsService.easypost.service.ProjectMaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project-materials")
@AllArgsConstructor
public class ProjectMaterialsController {
    private ProjectMaterialsService projectMaterialsService;

    @PostMapping
    public ResponseEntity<ProjectMaterials> createProjectMaterial(@RequestBody ProjectMaterials projectMaterials) {
        ProjectMaterials createdMaterial = projectMaterialsService.createProjectMaterials(projectMaterials);
        return new ResponseEntity<>(createdMaterial, HttpStatus.CREATED);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ProjectMaterials>> getProjectMaterialsByProjectId(@PathVariable Long projectId) {
        List<ProjectMaterials> materials = projectMaterialsService.getProjectMaterialsByProjectId(projectId);
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/project/{projectId}/material/{materialId}")
    public ResponseEntity<ProjectMaterials> getProjectMaterialsByProjectIdAndMaterialId(@PathVariable Long projectId, @PathVariable Long materialId) {
        ProjectMaterials material = projectMaterialsService.getProjectMaterialsByProjectIdAndMaterialId(projectId, materialId);
        return ResponseEntity.ok(material);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectMaterials> updateProjectMaterial(@PathVariable Long id, @RequestBody ProjectMaterials projectMaterialsDetails) {
        ProjectMaterials updatedMaterial = projectMaterialsService.updateProjectMaterials(id, projectMaterialsDetails);
        return ResponseEntity.ok(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectMaterial(@PathVariable Long id) {
        projectMaterialsService.deleteProjectMaterials(id);
        return ResponseEntity.noContent().build();
    }
}
