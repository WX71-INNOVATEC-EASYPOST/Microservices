package com.example.MaterialsService.easypost.dto.mapper;

import lombok.Data;

@Data
public class MaterialResponse {
    private Long id;
    private String materialName;
    private String materialDescription;
    private double materialCost;
}
