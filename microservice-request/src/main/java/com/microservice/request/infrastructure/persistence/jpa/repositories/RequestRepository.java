package com.microservice.request.infrastructure.persistence.jpa.repositories;

import com.microservice.request.domain.model.aggregates.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findAllByStatus(String status);
}
