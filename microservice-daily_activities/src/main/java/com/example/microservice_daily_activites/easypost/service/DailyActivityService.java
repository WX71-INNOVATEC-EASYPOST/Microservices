package com.example.microservice_daily_activites.easypost.service;

import com.example.microservice_daily_activites.easypost.model.DailyActivity;

import java.util.List;

public interface DailyActivityService {
    DailyActivity createDailyActivity(DailyActivity dailyActivity);
    List<DailyActivity> getAllDailyActivities();
    DailyActivity getDailyActivityById(Long id);
    List<DailyActivity> getAllDailyActivitiesByProjectId(Long projectId);
    DailyActivity updateDailyActivity(DailyActivity dailyActivity);
    void deleteDailyActivity(Long id);
}
