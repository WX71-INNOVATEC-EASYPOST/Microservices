package com.example.MaterialsService.easypost.dto.mapper;

import lombok.Data;

@Data
public class ProjectMaterialRequest {
    Long projectId;
    Long materialId;
    double amount;
}
