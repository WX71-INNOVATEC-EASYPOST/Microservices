package com.microservice.request.Interface.rest.transform;

import com.microservice.request.Interface.rest.resources.RequestResource;
import com.microservice.request.domain.model.aggregates.Request;

public class RequestResourceFromEntityAssembler {
        public static RequestResource toResourceFromEntity(Request request) {
            return new RequestResource(request.getId(), request.getUserIdFrom(), request.getUserIdTo(), request.getTitle(), request.getDescription(), request.getStatus(), request.getLocationId(), request.getIssueDate().toString());
        }
}
