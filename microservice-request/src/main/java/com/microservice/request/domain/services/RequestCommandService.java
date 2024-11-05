package com.microservice.request.domain.services;

import com.microservice.request.domain.model.aggregates.Request;
import com.microservice.request.domain.model.commands.CreateRequestCommand;
import com.microservice.request.domain.model.commands.DeleteRequestCommand;
import com.microservice.request.domain.model.commands.UpdateStatusRequestCommand;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RequestCommandService {
    Optional<Request> handle(CreateRequestCommand command, Long userIdFrom, Long userIdTo, Long locationId, LocalDateTime issueDate);
    Optional<Request> handle(UpdateStatusRequestCommand command);
    void handle(DeleteRequestCommand command);
}