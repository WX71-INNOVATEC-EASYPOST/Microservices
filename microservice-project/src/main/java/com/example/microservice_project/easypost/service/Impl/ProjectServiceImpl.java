package com.example.microservice_project.easypost.service.Impl;

import com.example.microservice_project.easypost.model.Location;
import com.example.microservice_project.easypost.model.Project;
import com.example.microservice_project.easypost.repository.ProjectRepository;
import com.example.microservice_project.easypost.service.ProjectService;
import com.example.microservice_project.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ValidationException("Project not found"));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectByLocationId(Location locationId) {
        return projectRepository.findByLocationId(locationId);
    }
}
