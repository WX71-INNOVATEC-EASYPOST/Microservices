package com.example.microservice_daily_activites.easypost.service.Impl;

import com.example.microservice_daily_activites.easypost.model.DailyActivity;
import com.example.microservice_daily_activites.easypost.repository.DailyActivityRepository;
import com.example.microservice_daily_activites.easypost.service.DailyActivityService;
import com.example.microservice_daily_activites.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyActivityServiceImpl implements DailyActivityService {
    @Autowired
    private DailyActivityRepository dailyActivityRepository;


    @Override
    public DailyActivity createDailyActivity(DailyActivity dailyActivity) {
        return dailyActivityRepository.save(dailyActivity);
    }

    @Override
    public List<DailyActivity> getAllDailyActivities() {
        return dailyActivityRepository.findAll();
    }

    @Override
    public DailyActivity getDailyActivityById(Long id) {
        return dailyActivityRepository.findById(id).orElseThrow(() -> new ValidationException("Daily Activity Not Found"));
    }

    @Override
    public List<DailyActivity> getAllDailyActivitiesByProjectId(Long projectId) {
        return dailyActivityRepository.findAllByProjectId(projectId);
    }

    @Override
    public DailyActivity updateDailyActivity(DailyActivity dailyActivity) {
        Optional<DailyActivity> existingDailyActivity = dailyActivityRepository.findById(dailyActivity.getId());
        if (existingDailyActivity.isPresent()) {
            DailyActivity updatedDailyActivity = existingDailyActivity.get();
            updatedDailyActivity.setName(dailyActivity.getName());
            updatedDailyActivity.setDescription(dailyActivity.getDescription());
            updatedDailyActivity.setProjectId(dailyActivity.getProjectId());
            updatedDailyActivity.setImage(updatedDailyActivity.getImage());
            updatedDailyActivity.setStatus(dailyActivity.getStatus());
            return dailyActivityRepository.save(updatedDailyActivity);
        } else {
            throw new ValidationException("Daily Activity Not Found");
        }
    }

    @Override
    public void deleteDailyActivity(Long id) {
        dailyActivityRepository.deleteById(id);
    }
}
