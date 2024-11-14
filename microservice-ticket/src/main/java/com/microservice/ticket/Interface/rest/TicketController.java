package com.microservice.ticket.Interface.rest;

import com.microservice.ticket.Interface.rest.resources.CreateTicketResource;
import com.microservice.ticket.Interface.rest.resources.TicketResource;
import com.microservice.ticket.Interface.rest.transform.CreateTicketCommandFromResourceAssembler;
import com.microservice.ticket.Interface.rest.transform.TicketResourceFromEntityAssembler;
import com.microservice.ticket.domain.model.entity.Ticket;
import com.microservice.ticket.domain.model.queries.GetAllTicketsByStatusQuery;
import com.microservice.ticket.domain.model.queries.GetAllTicketsQuery;
import com.microservice.ticket.domain.model.queries.GetTicketByIdQuery;
import com.microservice.ticket.domain.model.valueobjects.Status;
import com.microservice.ticket.domain.services.TicketCommandService;
import com.microservice.ticket.domain.services.TicketQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "api/v1/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Ticket", description = "Ticket Management Endpoints")
public class TicketController {
    private final TicketQueryService ticketQueryService;
    private final TicketCommandService ticketCommandService;
    public TicketController(TicketQueryService ticketQueryService, TicketCommandService ticketCommandService) {
        this.ticketQueryService = ticketQueryService;
        this.ticketCommandService = ticketCommandService;
    }

    @PostMapping
    public ResponseEntity<TicketResource> createTicket(@RequestBody CreateTicketResource createTicketResource) {
        Optional<Ticket> ticketSource = ticketCommandService
                .handle(CreateTicketCommandFromResourceAssembler.toCommandFromResource(createTicketResource));
        return ticketSource.map(source ->
                new ResponseEntity<>(TicketResourceFromEntityAssembler
                        .toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResource> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticketSource = ticketQueryService.handle(new GetTicketByIdQuery(id));
        return ticketSource.map(source -> ResponseEntity.ok(TicketResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TicketResource>> getAllTickets() {
        List<Ticket> ticketSource = ticketQueryService.handle(new GetAllTicketsQuery());
        var ticketResource = ticketSource.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ticketResource);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TicketResource>> getAllTicketsByStatus(@PathVariable Status status) {
        List<Ticket> ticketSource = ticketQueryService.handle(new GetAllTicketsByStatusQuery(status));
        List<TicketResource> ticketResource = ticketSource.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(ticketResource);
    }
}
