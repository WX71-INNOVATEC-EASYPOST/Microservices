package com.example.MaterialsService.easypost.service;

import com.example.MaterialsService.easypost.model.Materials;

import java.util.List;

public interface MaterialsService {
    Materials createMaterials(Materials materials);
    Materials getMaterialsById(Long id);
    Materials getMaterialsByName(String name);
    List<Materials> getAllMaterials();
    Materials updateMaterials(Long id, Materials materialsDetails);
    void deleteMaterials(Long id);
}
