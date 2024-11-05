package com.microservice.request.Interface.rest.transform;

import com.microservice.request.Interface.rest.resources.UpdateRequestStatusResource;
import com.microservice.request.domain.model.commands.UpdateStatusRequestCommand;

public class UpdateRequestCommandFromResourceAssembler {
    public static UpdateStatusRequestCommand toCommandFromResource(Long requestId, UpdateRequestStatusResource updateRequestStatusResource) {
        return new UpdateStatusRequestCommand(requestId, updateRequestStatusResource.status());
    }
}
