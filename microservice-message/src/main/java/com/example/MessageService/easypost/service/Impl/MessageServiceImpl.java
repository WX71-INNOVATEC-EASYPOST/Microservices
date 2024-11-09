package com.example.MessageService.easypost.service.Impl;

import com.example.MessageService.easypost.model.Message;
import com.example.MessageService.easypost.repository.MessageRepository;
import com.example.MessageService.easypost.service.MessageService;
import com.example.MessageService.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElseThrow(()-> new ValidationException("Message not found"));
    }

    @Override
    public List<Message> getAllMessagesByRecipientAndSenderId(Long recipientId, Long senderId) {
        return messageRepository.findAllByRecipientIdAndSenderId(recipientId, senderId);
    }
}
