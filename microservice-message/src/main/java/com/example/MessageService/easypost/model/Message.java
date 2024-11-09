package com.example.MessageService.easypost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "recipient-id", nullable = false)
    private Long recipientId;

    @Column(name = "sender-id", nullable = false)
    private Long senderId;

    @Column(name = "sent-time", nullable = false)
    private LocalDateTime sentTime;
}
