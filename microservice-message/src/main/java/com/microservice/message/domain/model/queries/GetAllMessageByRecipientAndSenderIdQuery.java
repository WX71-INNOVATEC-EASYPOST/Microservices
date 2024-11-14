package com.microservice.message.domain.model.queries;

public record GetAllMessageByRecipientAndSenderIdQuery(Long recipientId, Long senderId) {
    public GetAllMessageByRecipientAndSenderIdQuery {
        if(recipientId == null || recipientId == 0 ){
            throw new IllegalArgumentException("recipientId is null or empty");
        }
        if(senderId == null || senderId == 0 ){
            throw new IllegalArgumentException("senderId is null or empty");
        }
    }
}
