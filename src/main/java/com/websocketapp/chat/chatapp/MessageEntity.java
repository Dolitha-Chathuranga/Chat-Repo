package com.websocketapp.chat.chatapp;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name ="chat-messages")
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String content;

    @Column
    private String name;

    public MessageEntity() {
    }

    public MessageEntity(Long id, String content, LocalDateTime timestamp, String name) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
        this.name = name;
    }

    @Column
    private LocalDateTime timestamp;
}

