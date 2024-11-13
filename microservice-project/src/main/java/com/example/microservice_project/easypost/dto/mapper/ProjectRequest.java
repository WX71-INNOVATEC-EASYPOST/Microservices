package com.example.microservice_project.easypost.dto.mapper;

import com.example.microservice_project.easypost.model.Location;
import lombok.Data;
import java.util.List;

@Data
public class ProjectRequest {
    private String title;
    private String accessCode;
    private Long companyProfileId;
    private Long totalBudget;
    private Long partialBudget;
    private Location locationId;
    private List<Long> projectMaterialsIds;
    private Long requestId;
}
