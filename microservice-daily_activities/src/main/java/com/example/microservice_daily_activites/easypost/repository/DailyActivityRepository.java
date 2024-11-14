package com.example.microservice_daily_activites.easypost.repository;

import com.example.microservice_daily_activites.easypost.model.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyActivityRepository extends JpaRepository<DailyActivity, Long> {
    List<DailyActivity> findAllByProjectId(Long projectId);
}
