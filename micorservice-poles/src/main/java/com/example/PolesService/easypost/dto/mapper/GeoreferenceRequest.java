package com.example.PolesService.easypost.dto.mapper;

import lombok.Data;

@Data
public class GeoreferenceRequest {
    private String latitude;
    private String longitude;
    private String description;
}
