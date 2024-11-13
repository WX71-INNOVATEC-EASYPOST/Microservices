package com.example.microservice_project.easypost.controller;

import com.example.microservice_project.easypost.model.Location;
import com.example.microservice_project.easypost.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        return ResponseEntity.ok(createdLocation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        Location location = locationService.getLocationById(id);
        return ResponseEntity.ok(location);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> allLocations = locationService.getAllLocations();
        return ResponseEntity.ok(allLocations);
    }
}
