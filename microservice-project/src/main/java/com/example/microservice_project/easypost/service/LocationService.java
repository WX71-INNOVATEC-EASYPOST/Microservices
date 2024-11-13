package com.example.microservice_project.easypost.service;

import com.example.microservice_project.easypost.model.Location;

import java.util.List;

public interface LocationService {
    Location createLocation(Location location);
    Location getLocationById(Long id);
    List<Location> getAllLocations();
}
