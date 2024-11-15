package com.microservice.message.Interface.rest.transform;

import com.microservice.message.Interface.rest.resources.CreateMessageResource;
import com.microservice.message.domain.model.command.CreateMessageCommand;

import java.time.LocalDateTime;

public class CreateMessageCommandFromResourceFromAssembler {
    public static CreateMessageCommand toCommandFromResource(CreateMessageResource createMessageResource){
        return new CreateMessageCommand(
                createMessageResource.text(),
                createMessageResource.senderId(),
                createMessageResource.recipientId(),
                createMessageResource.sentTime()
        );
    }
}
