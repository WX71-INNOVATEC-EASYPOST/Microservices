package com.example.microservice_daily_activites.easypost.dto.mapper;

import com.example.microservice_daily_activites.easypost.model.Enum.Status;
import lombok.Data;

@Data
public class DailyActivityResponse {
    private Long id;
    private String description;
    private String name;
    private Long projectId;
    private String image;
    private Status status;
}
