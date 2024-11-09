package com.example.PolesService.easypost.dto.mapper;

import com.example.PolesService.easypost.model.GeoReference;
import lombok.Data;

@Data
public class PoleResponse {
    private Long id;
    private String description;
    private Long projectId;
    private GeoReference georeferenceId;
}
