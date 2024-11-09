package com.example.MaterialsService.easypost.controller;

import com.example.MaterialsService.easypost.model.Materials;
import com.example.MaterialsService.easypost.service.MaterialsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materials")
@AllArgsConstructor
public class MaterialsController {
    private MaterialsService materialsService;

    @PostMapping
    public ResponseEntity<Materials> createMaterial(@RequestBody Materials materials) {
        Materials createMaterials = materialsService.createMaterials(materials);
        return ResponseEntity.ok(createMaterials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materials> getMaterialById(@PathVariable Long id) {
        Materials materials = materialsService.getMaterialsById(id);
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/materials-name/{name}")
    public  ResponseEntity<Materials> getMaterialsByName(@PathVariable String name) {
        Materials materials = materialsService.getMaterialsByName(name);
        return ResponseEntity.ok(materials);
    }

    @GetMapping
    public ResponseEntity<List<Materials>> getAllMaterials() {
        List<Materials> materials = materialsService.getAllMaterials();
        return ResponseEntity.ok(materials);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materials> updateMaterial(@PathVariable Long id, @RequestBody Materials materialsDetails) {
        Materials updatedMaterial = materialsService.updateMaterials(id, materialsDetails);
        return ResponseEntity.ok(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Materials> deleteMaterial(@PathVariable Long id) {
        materialsService.deleteMaterials(id);
        return ResponseEntity.noContent().build();
    }
}
