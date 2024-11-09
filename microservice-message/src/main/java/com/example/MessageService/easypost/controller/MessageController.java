package com.example.MessageService.easypost.controller;

import com.example.MessageService.easypost.model.Message;
import com.example.MessageService.easypost.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
@AllArgsConstructor
public class MessageController {
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/recipient/{recipientId}/sender/{senderId}")
    public ResponseEntity<List<Message>> getMessagesByRecipientAndSenderId(@PathVariable Long recipientId, @PathVariable Long senderId) {
        List<Message> messages = messageService.getAllMessagesByRecipientAndSenderId(recipientId, senderId);
        return ResponseEntity.ok(messages);
    }
}
