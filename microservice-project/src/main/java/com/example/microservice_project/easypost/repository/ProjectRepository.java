package com.example.microservice_project.easypost.repository;

import com.example.microservice_project.easypost.model.Location;
import com.example.microservice_project.easypost.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByLocationId(Location locationId);
    Project findByAccessCode(String accessCode);
}
