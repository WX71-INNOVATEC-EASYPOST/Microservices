package com.microservice.message.domain.model.command;

import java.time.LocalDateTime;

public record CreateMessageCommand(
        String text,
        Long recipientId,
        Long senderId,
        LocalDateTime sentTime
) {
    public CreateMessageCommand {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        if (recipientId == null ) {
            throw new IllegalArgumentException("Both recipientId and senderId cannot be null");
        }
        if (senderId == null ) {
            throw new IllegalArgumentException("Both senderId and senderId cannot be null");
        }
        if (sentTime == null ) {
            throw new IllegalArgumentException("Both sentTime and sentTime cannot be null");
        }
    }
}
