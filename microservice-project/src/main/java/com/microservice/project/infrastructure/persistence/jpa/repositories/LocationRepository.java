package com.microservice.project.infrastructure.persistence.jpa.repositories;

import com.microservice.project.domain.model.aggregates.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
