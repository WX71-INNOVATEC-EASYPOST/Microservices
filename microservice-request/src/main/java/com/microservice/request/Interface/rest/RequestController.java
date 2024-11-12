package com.microservice.request.Interface.rest;

import com.microservice.request.Interface.rest.resources.CreateRequestResource;
import com.microservice.request.Interface.rest.resources.RequestResource;
import com.microservice.request.Interface.rest.resources.UpdateRequestStatusResource;
import com.microservice.request.Interface.rest.transform.CreateRequestCommandFromResourceAssembler;
import com.microservice.request.Interface.rest.transform.RequestResourceFromEntityAssembler;
import com.microservice.request.domain.model.aggregates.Request;
import com.microservice.request.domain.model.commands.UpdateStatusRequestCommand;
import com.microservice.request.domain.model.queries.GetAllRequestQuery;
import com.microservice.request.domain.model.queries.GetRequestByIdQuery;
import com.microservice.request.domain.services.RequestCommandService;
import com.microservice.request.domain.services.RequestQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "api/v1/resquest", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Request", description = "Request Management Endpoints")
public class RequestController {

    private final RequestQueryService requestQueryService;
    private final RequestCommandService requestCommandService;

    public RequestController(RequestQueryService requestQueryService, RequestCommandService requestCommandService) {
        this.requestQueryService = requestQueryService;
        this.requestCommandService = requestCommandService;
    }

    @PostMapping
    public ResponseEntity<RequestResource> createRequest(
            @RequestBody CreateRequestResource createRequestResource) {
        Optional<Request> requestSource = requestCommandService
                .handle(CreateRequestCommandFromResourceAssembler.toCommandFromResource(createRequestResource));
        return requestSource.map(source ->
                        new ResponseEntity<>(RequestResourceFromEntityAssembler
                                .toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<RequestResource>> getAllRequests() {
        List<Request> requestSource = requestQueryService.handle(new GetAllRequestQuery());
        var requestResource = requestSource
                .stream().map(RequestResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(requestResource);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<RequestResource> getRequestById(@PathVariable Long requestId) {
        Optional<Request> requestSource = requestQueryService.handle(new GetRequestByIdQuery(requestId));
        return requestSource.map(source -> ResponseEntity.ok(RequestResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<RequestResource> updateRequest(@PathVariable Long requestId,
                                                         @RequestBody UpdateRequestStatusResource updateRequestStatusResource) {
        Optional<Request> requestSource = requestCommandService
                .handle(new UpdateStatusRequestCommand(requestId, updateRequestStatusResource.status()));
        return requestSource.map(source ->
                        new ResponseEntity<>(RequestResourceFromEntityAssembler
                                .toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
