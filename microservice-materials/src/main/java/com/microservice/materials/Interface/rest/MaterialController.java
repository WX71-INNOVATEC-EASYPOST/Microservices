package com.microservice.materials.Interface.rest;

import com.microservice.materials.Interface.rest.resources.CreateMaterialResource;
import com.microservice.materials.Interface.rest.resources.MaterialResource;
import com.microservice.materials.Interface.rest.resources.UpdateMaterialResource;
import com.microservice.materials.Interface.rest.transform.CreateMaterialCommandFromResourceAssembler;
import com.microservice.materials.Interface.rest.transform.MaterialResourceFromEntityAssembler;
import com.microservice.materials.domain.model.commands.DeleteMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateMaterialCommand;
import com.microservice.materials.domain.model.entity.Materials;
import com.microservice.materials.domain.model.queries.GetAllMaterialsQuery;
import com.microservice.materials.domain.model.queries.GetMaterialsByIdQuery;
import com.microservice.materials.domain.model.queries.GetMaterialsByNameQuery;
import com.microservice.materials.domain.services.MaterialCommandService;
import com.microservice.materials.domain.services.MaterialQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "api/v1/material", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Material", description = "Material Management Endpoints")
public class MaterialController {
    private final MaterialQueryService materialQueryService;
    private final MaterialCommandService materialCommandService;
    public MaterialController(MaterialQueryService materialQueryService, MaterialCommandService materialCommandService) {
        this.materialQueryService = materialQueryService;
        this.materialCommandService = materialCommandService;
    }

    @PostMapping
    public ResponseEntity<MaterialResource> createMaterial(@RequestBody CreateMaterialResource createMaterialResource) {
        Optional<Materials> materialSource = materialCommandService
                .handle(CreateMaterialCommandFromResourceAssembler.toCommandFromResource(createMaterialResource));
        return materialSource.map(source ->
                new ResponseEntity<>(MaterialResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<MaterialResource>> getAllMaterials() {
        List<Materials> materialSource = materialQueryService.handle(new GetAllMaterialsQuery());
        var materialResource = materialSource.stream()
                .map(MaterialResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(materialResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialResource> getMaterialById(@PathVariable Long id) {
        Optional<Materials> materialSource = materialQueryService.handle(new GetMaterialsByIdQuery(id));
        return materialSource.map(source -> ResponseEntity.ok(MaterialResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<MaterialResource> getMaterialByName(@PathVariable String name) {
        Optional<Materials> materialSource = materialQueryService.handle(new GetMaterialsByNameQuery(name));
        return  materialSource.map(source -> ResponseEntity.ok(MaterialResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialResource> updateMaterial(@PathVariable Long id, @RequestBody UpdateMaterialResource updateMaterialResource) {
        UpdateMaterialCommand command = new UpdateMaterialCommand(
                id,
                updateMaterialResource.name(),
                updateMaterialResource.description(),
                updateMaterialResource.cost()
        );
        Optional<Materials> materialsSource = materialCommandService.handle(command);
        return materialsSource.map(source ->
                new ResponseEntity<>(MaterialResourceFromEntityAssembler
                        .toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        DeleteMaterialCommand command = new DeleteMaterialCommand(id);
        materialCommandService.handle(command);
        return ResponseEntity.noContent().build();
    }
}
