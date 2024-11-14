package com.microservice.project.Interface.rest.transform;

import com.microservice.project.Interface.rest.resources.LocationResource;
import com.microservice.project.domain.model.aggregates.Location;

public class LocationResourceFromEntityAssembler {
    public static LocationResource toResourceFromEntity(Location location) {
        return new LocationResource(
                location.getDepartment(),
                location.getProvince(),
                location.getDistrict(),
                location.getLocality(),
                location.getAddress(),
                location.getReference(),
                location.getProjects(),
                location.getRequestId()
        );
    }
}
