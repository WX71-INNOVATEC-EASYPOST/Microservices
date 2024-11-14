package com.microservice.project.application.internal.queryservices;

import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.queries.GetAllLocationsQuery;
import com.microservice.project.domain.model.queries.GetLocationByIdQuery;
import com.microservice.project.domain.services.LocationQueryService;
import com.microservice.project.infrastructure.persistence.jpa.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationQueryServiceImpl implements LocationQueryService {

    private final LocationRepository locationRepository;

    public LocationQueryServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> handle(GetAllLocationsQuery query) {
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> handle(GetLocationByIdQuery query) {
        return locationRepository.findById(query.id());
    }
}
