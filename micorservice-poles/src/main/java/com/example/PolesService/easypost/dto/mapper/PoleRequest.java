package com.example.PolesService.easypost.dto.mapper;

import com.example.PolesService.easypost.model.GeoReference;
import lombok.Data;

@Data
public class PoleRequest {
    private String description;
    private Long projectId;
    private Long georeferenceId;
}
