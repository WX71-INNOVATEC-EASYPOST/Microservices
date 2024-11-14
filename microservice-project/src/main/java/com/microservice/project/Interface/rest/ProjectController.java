package com.microservice.project.Interface.rest;

import com.microservice.project.Interface.rest.resources.CreateLocationResource;
import com.microservice.project.Interface.rest.resources.CreateProjectResource;
import com.microservice.project.Interface.rest.resources.ProjectResource;
import com.microservice.project.Interface.rest.transform.CreateProjectCommandFromResourceAssembler;
import com.microservice.project.Interface.rest.transform.ProjectResourceFromEntityAssembler;
import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.entity.Project;
import com.microservice.project.domain.model.queries.GetAllProjectsQuery;
import com.microservice.project.domain.model.queries.GetProjectByIdQuery;
import com.microservice.project.domain.model.queries.GetProjectByLocationIdQuery;
import com.microservice.project.domain.services.ProjectCommandService;
import com.microservice.project.domain.services.ProjectQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/project", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Project", description = "Project Management Endpoints")
public class ProjectController {
    private final ProjectQueryService projectQueryService;
    private final ProjectCommandService projectCommandService;

    public ProjectController(ProjectQueryService projectQueryService, ProjectCommandService projectCommandService) {
        this.projectQueryService = projectQueryService;
        this.projectCommandService = projectCommandService;
    }

    @PostMapping
    public ResponseEntity<ProjectResource> createProject(@RequestBody CreateProjectResource createProjectResource) {
        Optional<Project> projectSource = projectCommandService.handle(CreateProjectCommandFromResourceAssembler.toCommandFromResource(createProjectResource));
        return projectSource.map(source ->
                new ResponseEntity<>(ProjectResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResource> getProjectById(@PathVariable Long id) {
        Optional<Project> projectSource = projectQueryService.handle(new GetProjectByIdQuery(id));
        return projectSource.map(source -> ResponseEntity.ok(ProjectResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProjectResource>> getAllProjects() {
        List<Project> projectSource = projectQueryService.handle(new GetAllProjectsQuery());
        var projectResource = projectSource
                .stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(projectResource);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<ProjectResource> getProjectByLocationId(@PathVariable Long locationId) {
        Optional<Project> projectSource = projectQueryService.handle(new GetProjectByLocationIdQuery(locationId));
        return projectSource.map(source -> ResponseEntity.ok(ProjectResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

}
