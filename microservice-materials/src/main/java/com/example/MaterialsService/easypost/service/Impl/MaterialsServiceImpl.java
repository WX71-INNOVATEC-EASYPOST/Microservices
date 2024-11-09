package com.example.MaterialsService.easypost.service.Impl;

import com.example.MaterialsService.easypost.model.Materials;
import com.example.MaterialsService.easypost.repository.MaterialsRepository;
import com.example.MaterialsService.easypost.service.MaterialsService;
import com.example.MaterialsService.shared.exception.ResourceNotFoundException;
import com.example.MaterialsService.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsServiceImpl implements MaterialsService {
    @Autowired
    private MaterialsRepository materialsRepository;

    @Override
    public Materials createMaterials(Materials materials) {
        existsMaterialsById(materials);
        return materialsRepository.save(materials);
    }

    @Override
    public Materials getMaterialsById(Long id) {
        return materialsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Material not found with id: " + id));
    }

    @Override
    public Materials getMaterialsByName(String name) {
        return materialsRepository.findMaterialsByName(name);
    }

    @Override
    public List<Materials> getAllMaterials() {
        return materialsRepository.findAll();
    }

    @Override
    public Materials updateMaterials(Long id, Materials materialsDetails) {
        Materials materials = getMaterialsById(id);
        materials.setName(materialsDetails.getName());
        materials.setDescription(materialsDetails.getDescription());
        materials.setCost(materialsDetails.getCost());
        return materialsRepository.save(materials);
    }

    @Override
    public void deleteMaterials(Long id) {
        Materials materials = getMaterialsById(id);
        materialsRepository.delete(materials);
    }

    private void existsMaterialsById(Materials materials) {
        if (materialsRepository.existsMaterialsById(materials.getId())) {
            throw new ValidationException("Material already exists");
        }
    }
}
