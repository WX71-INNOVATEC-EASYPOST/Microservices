package com.example.PolesService.easypost.controller;

import com.example.PolesService.easypost.model.GeoReference;
import com.example.PolesService.easypost.model.Pole;
import com.example.PolesService.easypost.service.PoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pole")
@AllArgsConstructor
public class PoleController {
    private PoleService poleService;

    @PostMapping
    public ResponseEntity<Pole> createPole(@RequestBody Pole pole) {
        Pole createdPole = poleService.createPole(pole);
        return ResponseEntity.ok(createdPole);
    }

    @GetMapping
    public ResponseEntity<List<Pole>> getAllPoles() {
        List<Pole> allPoles = poleService.getAllPoles();
        return ResponseEntity.ok(allPoles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pole> getPoleById(@PathVariable Long id) {
        Pole pole = poleService.getPoleById(id);
        return ResponseEntity.ok(pole);
    }

    @GetMapping("/georeference/{georeferenceId}")
    public ResponseEntity<Pole> getPoleByReferenceId(@PathVariable Long georeferenceId) {
        Pole pole = poleService.getPoleByGeoreferenceId(georeferenceId);
        return ResponseEntity.ok(pole);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<Pole> getPoleByProjectId(@PathVariable Long projectId) {
        Pole pole = poleService.getPoleByProjectId(projectId);
        return ResponseEntity.ok(pole);
    }
}
