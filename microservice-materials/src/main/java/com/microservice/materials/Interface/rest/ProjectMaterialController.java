package com.microservice.materials.Interface.rest;

import com.microservice.materials.Interface.rest.resources.CreateProjectMaterialResource;
import com.microservice.materials.Interface.rest.resources.ProjectMaterialResource;
import com.microservice.materials.Interface.rest.resources.UpdateProjectMaterialResource;
import com.microservice.materials.Interface.rest.transform.CreateProjectMaterialCommandFromResourceAssembler;
import com.microservice.materials.Interface.rest.transform.ProjectMaterialResourceFromEntityAssembler;
import com.microservice.materials.domain.model.aggregates.ProjectMaterials;
import com.microservice.materials.domain.model.commands.DeleteProjectMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateProjectMaterialCommand;
import com.microservice.materials.domain.model.queries.GetAllProjectMaterialsByProjectIdQuery;
import com.microservice.materials.domain.model.queries.GetProjectMaterialsByProjectIdAndMaterialIdQuery;
import com.microservice.materials.domain.services.ProjectMaterialCommandService;
import com.microservice.materials.domain.services.ProjectMaterialQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "api/v1/project-material", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Project Material", description = "Project Material Management Endpoints")
public class ProjectMaterialController {
    private final ProjectMaterialCommandService projectMaterialCommandService;
    private final ProjectMaterialQueryService projectMaterialQueryService;
    public ProjectMaterialController(ProjectMaterialCommandService projectMaterialCommandService, ProjectMaterialQueryService projectMaterialQueryService) {
        this.projectMaterialCommandService = projectMaterialCommandService;
        this.projectMaterialQueryService = projectMaterialQueryService;
    }

    @PostMapping
    public ResponseEntity<ProjectMaterialResource> createProjectMaterial(@RequestBody CreateProjectMaterialResource createProjectMaterialResource) {
        Optional<ProjectMaterials> projectMaterialsSource = projectMaterialCommandService
                .handle(CreateProjectMaterialCommandFromResourceAssembler.toCommandFromResource(createProjectMaterialResource));
        return projectMaterialsSource.map(source ->
                new ResponseEntity<>(ProjectMaterialResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ProjectMaterialResource>> getProjectMaterial(@PathVariable Long projectId) {
        List<ProjectMaterials> projectMaterialSource = projectMaterialQueryService.handle(new GetAllProjectMaterialsByProjectIdQuery(projectId));
        var projectMaterialResource = projectMaterialSource.stream()
                .map(ProjectMaterialResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(projectMaterialResource);

    }

    @GetMapping("/project/{projectId}/material/{materialId}")
    public ResponseEntity<ProjectMaterialResource> getProjectMaterial(@PathVariable Long projectId, @PathVariable Long materialId) {
        Optional<ProjectMaterials> projectMaterialSource = projectMaterialQueryService
                .handle(new GetProjectMaterialsByProjectIdAndMaterialIdQuery(projectId, materialId));

        return projectMaterialSource.map(source ->
                new ResponseEntity<>(ProjectMaterialResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectMaterialResource> updateProjectMaterial(@PathVariable Long id, @RequestBody UpdateProjectMaterialResource updateProjectMaterialResource) {
        UpdateProjectMaterialCommand command = new UpdateProjectMaterialCommand(
                id,
                updateProjectMaterialResource.materialId(),
                updateProjectMaterialResource.projectId(),
                updateProjectMaterialResource.amount()
        );
        Optional<ProjectMaterials> projectMaterialSource = projectMaterialCommandService.handle(command);
        return projectMaterialSource.map(source ->
                new ResponseEntity<>(ProjectMaterialResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectMaterial(@PathVariable Long id) {
        DeleteProjectMaterialCommand command = new DeleteProjectMaterialCommand(id);
        projectMaterialCommandService.handle(command);
        return ResponseEntity.noContent().build();
    }
}
