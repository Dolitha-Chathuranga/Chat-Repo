package com.websocketapp.chat.chatapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSocketMessageRepository extends JpaRepository<MessageEntity, Long> {

}
