package com.microservice.request.domain.services;

import com.microservice.request.domain.model.aggregates.Request;
import com.microservice.request.domain.model.queries.GetAllRequestQuery;
import com.microservice.request.domain.model.queries.GetRequestByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RequestQueryService {
    List<Request> handle(GetAllRequestQuery query);
    Optional<Request> handle(GetRequestByIdQuery query);
}
