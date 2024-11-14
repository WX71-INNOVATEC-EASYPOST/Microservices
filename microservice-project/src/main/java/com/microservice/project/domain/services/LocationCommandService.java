package com.microservice.project.domain.services;

import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.commands.CreateLocationCommand;

import java.util.Optional;

public interface LocationCommandService {
    Optional<Location> handle(CreateLocationCommand command);
}
