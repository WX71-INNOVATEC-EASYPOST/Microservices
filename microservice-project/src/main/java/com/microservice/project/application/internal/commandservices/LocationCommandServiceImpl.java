package com.microservice.project.application.internal.commandservices;

import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.commands.CreateLocationCommand;
import com.microservice.project.domain.services.LocationCommandService;
import com.microservice.project.infrastructure.persistence.jpa.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationCommandServiceImpl implements LocationCommandService {
    @Autowired
    private final LocationRepository locationRepository;

    public LocationCommandServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Location> handle(CreateLocationCommand command) {
        var location = new Location(command);
        var createdLocation = locationRepository.save(location);
        return Optional.of(createdLocation);
    }
}
