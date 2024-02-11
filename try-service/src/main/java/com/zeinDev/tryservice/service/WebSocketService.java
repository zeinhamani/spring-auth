package com.zeinDev.tryservice.service;

import com.zeinDev.tryservice.entity.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketService {
    private SimpMessagingTemplate messagingTemplate;
    public  void  notifyFrontEnd(final Try message){
        messagingTemplate.convertAndSend("/topic/messages",message);
    }
    public void notifyUser(final String id, final Try message) {
        messagingTemplate.convertAndSendToUser(id, "/topic/private-messages", message);
    }
}
