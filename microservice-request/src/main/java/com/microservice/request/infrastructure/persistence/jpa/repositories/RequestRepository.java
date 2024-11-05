package com.microservice.request.infrastructure.persistence.jpa.repositories;

import com.microservice.request.domain.model.aggregates.Request;
import com.microservice.request.domain.model.valueobjects.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    @Query("SELECT r FROM Request r WHERE r.status = :status")
    List<Request> findAllByStatus(@Param("status") RequestStatus status);
}
