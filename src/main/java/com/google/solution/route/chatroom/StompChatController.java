package com.google.solution.route.chatroom;

import com.google.solution.route.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StompChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping(value = "/chat/enter")
    public void enter(MessageDto messageDto){
        messageDto.setMessage(messageDto.getWriter() + " 입장");
        simpMessagingTemplate.convertAndSend("/topic/stomp/chat/" + messageDto.getRoomId(), messageDto.getMessage());
    }

    @MessageMapping(value = "/chat/message")
    public void message(MessageDto messageDto) {
        simpMessagingTemplate.convertAndSend("/topic/stomp/chat/" + messageDto.getRoomId(), messageDto.getMessage());
    }


}
