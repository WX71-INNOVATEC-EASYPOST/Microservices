package com.example.microservice_project.easypost.service;

import com.example.microservice_project.easypost.model.Location;
import com.example.microservice_project.easypost.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long id);
    List<Project> getAllProjects();
    Project getProjectByLocationId(Location locationId);
}
