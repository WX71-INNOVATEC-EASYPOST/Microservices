package com.microservice.daily.activities.infrastructure.persistence.jpa.repositories;

import com.microservice.daily.activities.domain.model.aggregates.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DailyActivityRepository extends JpaRepository<DailyActivity, Long> {

    @Query("SELECT da FROM DailyActivity da WHERE da.projectId = :projectId")
    List<DailyActivity> findAllByProjectId(@Param("projectId") Long projectId);
}
