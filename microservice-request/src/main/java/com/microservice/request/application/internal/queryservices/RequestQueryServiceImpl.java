package com.microservice.request.application.internal.queryservices;

import com.microservice.request.domain.model.aggregates.Request;
import com.microservice.request.domain.model.queries.GetAllRequestQuery;
import com.microservice.request.domain.model.queries.GetRequestByIdQuery;
import com.microservice.request.domain.services.RequestQueryService;
import com.microservice.request.infrastructure.persistence.jpa.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestQueryServiceImpl implements RequestQueryService {

    private final RequestRepository requestRepository;

    public RequestQueryServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<Request> handle(GetAllRequestQuery query){
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> handle(GetRequestByIdQuery query){
        return requestRepository.findById(query.id());
    }
}