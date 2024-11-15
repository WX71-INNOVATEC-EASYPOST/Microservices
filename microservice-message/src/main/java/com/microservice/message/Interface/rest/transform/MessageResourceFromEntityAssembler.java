package com.microservice.message.Interface.rest.transform;

import com.microservice.message.Interface.rest.resources.MessageResource;
import com.microservice.message.domain.model.entity.Message;

public class MessageResourceFromEntityAssembler {
    public static MessageResource toResourceFromEntity(Message message) {
        return new MessageResource(
                message.getText(),
                message.getSenderId(),
                message.getRecipientId(),
                message.getSentTime()
        );
    }
}
