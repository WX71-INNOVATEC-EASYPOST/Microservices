package com.microservice.message.domain.services;

import com.microservice.message.domain.model.command.CreateMessageCommand;
import com.microservice.message.domain.model.entity.Message;

import java.util.Optional;

public interface MessageCommandService {
    Optional<Message> handle(CreateMessageCommand command);
}
