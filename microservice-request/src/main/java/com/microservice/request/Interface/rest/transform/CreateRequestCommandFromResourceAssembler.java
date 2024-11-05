package com.microservice.request.Interface.rest.transform;

import com.microservice.request.Interface.rest.resources.CreateRequestResource;
import com.microservice.request.domain.model.commands.CreateRequestCommand;

public class CreateRequestCommandFromResourceAssembler {

    public static CreateRequestCommand toCommandFromResource(CreateRequestResource createRequestResource) {
        return new CreateRequestCommand(createRequestResource.userIdFrom(), createRequestResource.userIdTo(), createRequestResource.title(), createRequestResource.description(), createRequestResource.status(), createRequestResource.locationId(), createRequestResource.issueDate());
    }
}
