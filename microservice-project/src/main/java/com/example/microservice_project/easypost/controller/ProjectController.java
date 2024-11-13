package com.example.microservice_project.easypost.controller;

import com.example.microservice_project.easypost.model.Location;
import com.example.microservice_project.easypost.model.Project;
import com.example.microservice_project.easypost.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Project> getProjectByLocationId(@PathVariable Location locationId) {
        Project project = projectService.getProjectByLocationId(locationId);
        return ResponseEntity.ok(project);
    }

}
