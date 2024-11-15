package com.example.PolesService.easypost.service;

import com.example.PolesService.easypost.model.GeoReference;

import java.util.List;

public interface GeoreferenceService {
    GeoReference createGeoReference(GeoReference geoReference);
    List<GeoReference> getAllGeoReferences();
    GeoReference getGeoReferenceById(Long id);
}
