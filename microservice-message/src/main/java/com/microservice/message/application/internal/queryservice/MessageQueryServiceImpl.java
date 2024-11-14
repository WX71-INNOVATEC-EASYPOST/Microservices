package com.microservice.message.application.internal.queryservice;

import com.microservice.message.domain.model.entity.Message;
import com.microservice.message.domain.model.queries.GetAllMessageByRecipientAndSenderIdQuery;
import com.microservice.message.domain.model.queries.GetMessageByIdQuery;
import com.microservice.message.domain.services.MessageQueryService;
import com.microservice.message.infrastructur.persistence.jpa.respositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageQueryServiceImpl implements MessageQueryService {
    public final MessageRepository messageRepository;
    public MessageQueryServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public Optional<Message> handle(GetMessageByIdQuery query) {
        return messageRepository.findById(query.id());
    }

    @Override
    public List<Message> handle(GetAllMessageByRecipientAndSenderIdQuery query) {
        return messageRepository.findAllByRecipientIdAndSenderId(query.recipientId(), query.senderId());
    }
}
