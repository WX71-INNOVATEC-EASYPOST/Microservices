package com.microservuce.daily_activites.infrastructure.persistence.jpa.repositories;

import com.microservuce.daily_activites.domain.model.entity.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyActivityRepository extends JpaRepository<DailyActivity, Long> {
    List<DailyActivity> findAllByProjectId(Long projectId);
}
