package com.example.MessageService.easypost.service;

import com.example.MessageService.easypost.model.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    Message getMessageById(Long id);
    List<Message> getAllMessagesByRecipientAndSenderId(Long recipientId, Long senderId);
}
