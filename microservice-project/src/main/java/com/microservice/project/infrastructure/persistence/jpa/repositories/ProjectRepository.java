package com.microservice.project.infrastructure.persistence.jpa.repositories;

import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByLocationId(Long locationId);
    Project findByAccessCode(String accessCode);
}
