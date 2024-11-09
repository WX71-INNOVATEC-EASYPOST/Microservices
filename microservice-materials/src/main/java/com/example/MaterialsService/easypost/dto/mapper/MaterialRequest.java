package com.example.MaterialsService.easypost.dto.mapper;

import lombok.Data;

@Data
public class MaterialRequest {
    private String materialName;
    private String materialDescription;
    private double materialCost;
}
