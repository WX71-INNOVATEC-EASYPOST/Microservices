package com.example.microservice_project.easypost.service.Impl;

import com.example.microservice_project.easypost.model.Location;
import com.example.microservice_project.easypost.repository.LocationRepository;
import com.example.microservice_project.easypost.service.LocationService;
import com.example.microservice_project.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new ValidationException("No location found"));
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
