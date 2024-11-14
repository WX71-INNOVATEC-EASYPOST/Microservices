package com.example.PolesService.easypost.controller;

import com.example.PolesService.easypost.model.GeoReference;
import com.example.PolesService.easypost.service.GeoreferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/georeference")
public class GeoreferenceController {
    private GeoreferenceService georeferenceService;

    @PostMapping
    public ResponseEntity<GeoReference> createGeoReference(@RequestBody GeoReference geoReference) {
        GeoReference createdGeoReference = georeferenceService.createGeoReference(geoReference);
        return ResponseEntity.ok(createdGeoReference);
    }

    @GetMapping
    public ResponseEntity<List<GeoReference>> getAllGeoReferences() {
        List<GeoReference> geoReferences = georeferenceService.getAllGeoReferences();
        return ResponseEntity.ok(geoReferences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeoReference> getGeoReferenceById(@PathVariable Long id) {
        GeoReference geoReference = georeferenceService.getGeoReferenceById(id);
        return ResponseEntity.ok(geoReference);
    }
}
