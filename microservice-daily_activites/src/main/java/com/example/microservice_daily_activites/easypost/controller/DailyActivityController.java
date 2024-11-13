package com.example.microservice_daily_activites.easypost.controller;

import com.example.microservice_daily_activites.easypost.model.DailyActivity;
import com.example.microservice_daily_activites.easypost.service.DailyActivityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/daily_activity")
@AllArgsConstructor
public class DailyActivityController {
    private DailyActivityService dailyActivityService;

    @PostMapping
    public ResponseEntity<DailyActivity> createDailyActivity(@RequestBody DailyActivity dailyActivity) {
        dailyActivityService.createDailyActivity(dailyActivity);
        return ResponseEntity.ok().body(dailyActivity);
    }

    @GetMapping
    public ResponseEntity<List<DailyActivity>> getAllDailyActivities() {
        return ResponseEntity.ok(dailyActivityService.getAllDailyActivities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyActivity> getDailyActivityById(@PathVariable Long id) {
        return ResponseEntity.ok(dailyActivityService.getDailyActivityById(id));
    }

    @GetMapping("/project_id/{projectId}")
    public ResponseEntity<List<DailyActivity>> getDailyActivitiesByProjectId(@PathVariable Long projectId) {
        return ResponseEntity.ok(dailyActivityService.getAllDailyActivitiesByProjectId(projectId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailyActivity> updateDailyActivity(@PathVariable Long id, @RequestBody DailyActivity dailyActivity) {
        try {
          dailyActivity.setId(id);
          DailyActivity updatedDailyActivity = dailyActivityService.updateDailyActivity(dailyActivity);

          return ResponseEntity.ok(updatedDailyActivity);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DailyActivity> deleteDailyActivity(@PathVariable Long id) {
        dailyActivityService.deleteDailyActivity(id);
        return ResponseEntity.noContent().build();
    }
}
