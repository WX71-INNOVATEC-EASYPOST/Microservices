package com.example.microservice_project.easypost.repository;

import com.example.microservice_project.easypost.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
