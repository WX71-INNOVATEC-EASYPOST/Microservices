package com.example.MessageService.easypost.dto.mapper;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageRequest {
    private String text;
    private Long recipientId;
    private Long senderId;
    private LocalDateTime sentTime;
}
