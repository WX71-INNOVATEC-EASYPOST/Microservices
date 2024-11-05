package com.microservice.request.domain.model.aggregates;

import com.microservice.request.domain.model.commands.CreateRequestCommand;
import com.microservice.request.domain.model.commands.UpdateStatusRequestCommand;
import com.microservice.request.domain.model.valueobjects.RequestStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userIdFrom;

    private Long userIdTo;

    private String title;

    private String description;

    private RequestStatus status;

    private Long locationId;
    private LocalDateTime issueDate;


    public Request() {
    }

    public Request(CreateRequestCommand command, Long userIdFrom, Long userIdTo, Long locationId, LocalDateTime issueDate) {
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.title = "Request " + command.requestTitle();
        this.description = command.requestDescription();
        this.status = RequestStatus.valueOf(command.requestStatus().toUpperCase());
        this.locationId = locationId;
        this.issueDate = issueDate;
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public void updateStatus(UpdateStatusRequestCommand newStatus) {
        this.status = RequestStatus.valueOf(newStatus.requestStatus().toUpperCase());
    }

    public void approve() {
        this.status = RequestStatus.APPROVED;
    }

    public void reject() {
        this.status = RequestStatus.REJECTED;
    }
}
