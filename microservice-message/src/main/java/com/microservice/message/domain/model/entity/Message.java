package com.microservice.message.domain.model.entity;

import com.microservice.message.domain.model.command.CreateMessageCommand;
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

    public Message(CreateMessageCommand command){
        this.text = command.text();
        this.recipientId = command.recipientId();
        this.senderId = command.senderId();
        this.sentTime = command.sentTime();
    }
}
