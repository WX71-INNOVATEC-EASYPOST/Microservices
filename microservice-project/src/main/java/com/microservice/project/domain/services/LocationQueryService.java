package com.microservice.project.domain.services;

import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.queries.GetAllLocationsQuery;
import com.microservice.project.domain.model.queries.GetLocationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface LocationQueryService {
    List<Location> handle(GetAllLocationsQuery query);
    Optional<Location> handle(GetLocationByIdQuery query);
}
