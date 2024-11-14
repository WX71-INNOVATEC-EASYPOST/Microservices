package com.example.PolesService.easypost.service.Impl;

import com.example.PolesService.easypost.model.GeoReference;
import com.example.PolesService.easypost.repository.GeoreferenceRepository;
import com.example.PolesService.easypost.service.GeoreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoreferenceServiceImpl implements GeoreferenceService {
    @Autowired
    private GeoreferenceRepository georeferenceRepository;

    @Override
    public GeoReference createGeoReference(GeoReference geoReference) {
        return georeferenceRepository.save(geoReference);
    }

    @Override
    public List<GeoReference> getAllGeoReferences() {
        return georeferenceRepository.findAll();
    }

    @Override
    public GeoReference getGeoReferenceById(Long id) {
        return georeferenceRepository.getReferenceById(id);
    }
}
