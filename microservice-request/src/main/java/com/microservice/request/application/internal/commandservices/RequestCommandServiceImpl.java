package com.microservice.request.application.internal.commandservices;

import com.microservice.request.domain.model.aggregates.Request;
import com.microservice.request.domain.model.commands.CreateRequestCommand;
import com.microservice.request.domain.model.commands.DeleteRequestCommand;
import com.microservice.request.domain.model.commands.UpdateStatusRequestCommand;
import com.microservice.request.domain.services.RequestCommandService;
import com.microservice.request.infrastructure.persistence.jpa.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RequestCommandServiceImpl implements RequestCommandService {

    private final RequestRepository requestRepository;

    public RequestCommandServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Optional<Request> handle(CreateRequestCommand command, Long userIdFrom, Long userIdTo, Long locationId, LocalDateTime issueDate) {
        var request = new Request(command, userIdFrom, userIdTo, locationId, issueDate);
        var createdRequest = requestRepository.save(request);
        return Optional.of(createdRequest);
    }

    @Override
    public Optional<Request> handle(UpdateStatusRequestCommand command) {
        var result = requestRepository.findById(command.id());
        if (result.isEmpty()) throw new IllegalArgumentException("Request does not exist");
        var requestToUpdate = result.get();
        try {
            requestToUpdate.updateStatus(command);
            var updatedRequest = requestRepository.save(requestToUpdate);
            return Optional.of(updatedRequest);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating Request: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteRequestCommand command) {
        if (!requestRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Request does not exist");
        }
        try {
            requestRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting Request: " + e.getMessage());
        }
    }
}
