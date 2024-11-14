package com.microservice.project.Interface.rest;

import com.microservice.project.Interface.rest.resources.CreateLocationResource;
import com.microservice.project.Interface.rest.resources.LocationResource;
import com.microservice.project.Interface.rest.transform.CreateLocationCommandFromResourceAssembler;
import com.microservice.project.Interface.rest.transform.LocationResourceFromEntityAssembler;
import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.queries.GetAllLocationsQuery;
import com.microservice.project.domain.model.queries.GetLocationByIdQuery;
import com.microservice.project.domain.services.LocationCommandService;
import com.microservice.project.domain.services.LocationQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/location", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Location", description = "Location Management Endpoints")
public class LocationController {
    private final LocationQueryService locationQueryService;
    private final LocationCommandService locationCommandService;

    public LocationController(LocationQueryService locationQueryService, LocationCommandService locationCommandService) {
        this.locationQueryService = locationQueryService;
        this.locationCommandService = locationCommandService;
    }

    @PostMapping
    public ResponseEntity<LocationResource> createLocation(@RequestBody CreateLocationResource createLocationResource) {
        Optional<Location> locationSource = locationCommandService.handle(CreateLocationCommandFromResourceAssembler.toCommandFromResource(createLocationResource));
        return locationSource.map(source ->
                new ResponseEntity<>(LocationResourceFromEntityAssembler
                        .toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResource> getLocationById(@PathVariable Long id) {
       Optional<Location> locationSource = locationQueryService.handle(new GetLocationByIdQuery(id));
       return locationSource.map(source -> ResponseEntity.ok(LocationResourceFromEntityAssembler.toResourceFromEntity(source)))
               .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LocationResource>> getLocations() {
        List<Location> locationSource = locationQueryService.handle(new GetAllLocationsQuery());
        var locationResource = locationSource
                .stream().map(LocationResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(locationResource);
    }
}
