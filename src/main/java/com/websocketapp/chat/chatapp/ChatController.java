package com.websocketapp.chat.chatapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @MessageMapping("/chat.showMessage")
    @SendTo("/topic/public")
    public ChatMessage showMessage(
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @Autowired
    private WebSocketMessageRepository messageRepository;


    @MessageMapping("/chat.sendMessage")
    public void handleWebSocketMessage(String messageContent) {
        MessageEntity newMessage = new MessageEntity();
        newMessage.setContent(messageContent);
        //newMessage.setName(Arrays.toString(messageContent));
        newMessage.setTimestamp(LocalDateTime.now());
        messageRepository.save(newMessage);
    }
}
