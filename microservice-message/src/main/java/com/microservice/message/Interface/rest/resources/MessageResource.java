package com.microservice.message.Interface.rest.resources;

import java.time.LocalDateTime;

public record MessageResource(
        String text,
        Long recipientId,
        Long senderId,
        LocalDateTime sentTime
) {
}
