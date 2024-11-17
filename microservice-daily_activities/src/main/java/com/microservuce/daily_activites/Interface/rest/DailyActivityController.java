package com.microservuce.daily_activites.Interface.rest;

import com.microservuce.daily_activites.Interface.rest.resources.CreateDailyActivityResource;
import com.microservuce.daily_activites.Interface.rest.resources.DailyActivityResource;
import com.microservuce.daily_activites.Interface.rest.resources.UpdateDailyActivityResource;
import com.microservuce.daily_activites.Interface.rest.transform.CreateDailyActivityCommandFromResourceAssembler;
import com.microservuce.daily_activites.Interface.rest.transform.DailyActivityFromEntityAssembler;
import com.microservuce.daily_activites.domain.model.commands.DeleteDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.commands.UpdateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.entity.DailyActivity;
import com.microservuce.daily_activites.domain.model.queries.GetAllDailyActivitiesByProjectIdQuery;
import com.microservuce.daily_activites.domain.model.queries.GetAllDailyActivitiesQuery;
import com.microservuce.daily_activites.domain.model.queries.GetDailyActivityByIdQuery;
import com.microservuce.daily_activites.domain.services.DailyActivityCommandService;
import com.microservuce.daily_activites.domain.services.DailyActivityQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "api/v1/daily-activity", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "DailyActivity", description = "Daily Activity Management Endpoints")
public class DailyActivityController {
    private final DailyActivityQueryService dailyActivityQueryService;
    private final DailyActivityCommandService dailyActivityCommandService;
    private DailyActivityController(DailyActivityQueryService dailyActivityQueryService, DailyActivityCommandService dailyActivityCommandService) {
        this.dailyActivityQueryService = dailyActivityQueryService;
        this.dailyActivityCommandService = dailyActivityCommandService;
    }

    @PostMapping
    public ResponseEntity<DailyActivityResource> createMaterial(@RequestBody CreateDailyActivityResource createDailyActivityResource) {
        Optional<DailyActivity> dailyActivitySource = dailyActivityCommandService
                .handle(CreateDailyActivityCommandFromResourceAssembler.toCommandFromResource(createDailyActivityResource));
        return dailyActivitySource.map(source ->
                        new ResponseEntity<>(DailyActivityFromEntityAssembler.toResourceFromEntity(source), CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<DailyActivityResource>> getAllDailyActivities() {
        List<DailyActivity> dailyActivitySource = dailyActivityQueryService.handle(new GetAllDailyActivitiesQuery());
        var dailyActivityResource = dailyActivitySource.stream()
                .map(DailyActivityFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(dailyActivityResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyActivityResource> getDailyActivitylById(@PathVariable Long id) {
        Optional<DailyActivity> dailyActivitySource = dailyActivityQueryService.handle(new GetDailyActivityByIdQuery(id));
        return dailyActivitySource.map(source -> ResponseEntity.ok(DailyActivityFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<DailyActivityResource>> getAllDailyActivitiesByProjectId(@PathVariable Long projectId) {
        List<DailyActivity> dailyActivitySource = dailyActivityQueryService.handle(new GetAllDailyActivitiesByProjectIdQuery(projectId));
        var dailyActivityResource = dailyActivitySource.stream()
                .map(DailyActivityFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(dailyActivityResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailyActivityResource> updateDailyActivity(@PathVariable Long id, @RequestBody UpdateDailyActivityResource updateDailyActivityResource) {
        UpdateDailyActivityCommand command = new UpdateDailyActivityCommand(
                id,
                updateDailyActivityResource.description(),
                updateDailyActivityResource.name(),
                updateDailyActivityResource.projectId(),
                updateDailyActivityResource.image(),
                updateDailyActivityResource.status()
        );
        Optional<DailyActivity> dailyActivitySource = dailyActivityCommandService.handle(command);
        return dailyActivitySource.map(source ->
                        new ResponseEntity<>(DailyActivityFromEntityAssembler
                                .toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDailyActivity(@PathVariable Long id) {
        DeleteDailyActivityCommand command = new DeleteDailyActivityCommand(id);
        dailyActivityCommandService.handle(command);
        return ResponseEntity.noContent().build();
    }
}
