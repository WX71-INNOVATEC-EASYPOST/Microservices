package com.microservice.message.domain.services;

import com.microservice.message.domain.model.entity.Message;
import com.microservice.message.domain.model.queries.GetAllMessageByRecipientAndSenderIdQuery;
import com.microservice.message.domain.model.queries.GetMessageByIdQuery;

import java.util.List;
import java.util.Optional;

public interface MessageQueryService {
    Optional<Message> handle(GetMessageByIdQuery query);
    List<Message> handle(GetAllMessageByRecipientAndSenderIdQuery query);
}
