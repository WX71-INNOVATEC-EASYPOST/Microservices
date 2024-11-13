package com.example.microservice_project.easypost.dto.mapper;

import com.example.microservice_project.easypost.model.Project;
import lombok.Data;

import java.util.List;

@Data
public class LocationResponse {
    private Long id;
    private String department;
    private String province;
    private String district;
    private String locality;
    private String address;
    private String reference;
    private List<Project> projects;
    private Long requestId;
}
