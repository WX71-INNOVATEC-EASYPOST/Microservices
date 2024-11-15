package com.microservice.message.application.internal.commandservice;

import com.microservice.message.domain.model.command.CreateMessageCommand;
import com.microservice.message.domain.model.entity.Message;
import com.microservice.message.domain.services.MessageCommandService;
import com.microservice.message.infrastructur.persistence.jpa.respositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageCommandServiceImpl implements MessageCommandService {
    private final MessageRepository messageRepository;
    public MessageCommandServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<Message> handle(CreateMessageCommand command) {
        Message message = new Message(command);
        var createdMessage = messageRepository.save(message);
        return Optional.of(createdMessage);
    }
}
