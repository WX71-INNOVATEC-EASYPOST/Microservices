package com.example.MessageService.easypost.dto.mapper;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageResponse {
    private Long id;
    private String text;
    private Long recipientId;
    private Long senderId;
    private LocalDateTime sentTime;
}
