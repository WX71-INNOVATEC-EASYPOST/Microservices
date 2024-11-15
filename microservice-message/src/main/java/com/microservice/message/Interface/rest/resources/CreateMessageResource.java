package com.microservice.message.Interface.rest.resources;

import java.time.LocalDateTime;

public record CreateMessageResource(
        String text,
        Long recipientId,
        Long senderId,
        LocalDateTime sentTime
) {
    public CreateMessageResource {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        if (recipientId == null) {
            throw new IllegalArgumentException("RecipientId cannot be null");
        }
        if (senderId == null) {
            throw new IllegalArgumentException("SenderId cannot be null");
        }
        if (sentTime == null) {
            throw new IllegalArgumentException("SentTime cannot be null");
        }
    }
}
