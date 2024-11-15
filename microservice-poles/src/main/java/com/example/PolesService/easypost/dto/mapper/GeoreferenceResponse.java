package com.example.PolesService.easypost.dto.mapper;

import lombok.Data;

@Data
public class GeoreferenceResponse {
    private Long id;
    private String latitude;
    private String longitude;
    private String description;
}
