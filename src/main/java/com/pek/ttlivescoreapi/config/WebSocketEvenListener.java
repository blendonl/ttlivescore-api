package com.pek.ttlivescoreapi.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor

public class WebSocketEvenListener {

    @EventListener
    public void handleWebSocketDisconnect(SessionDisconnectEvent event) {}

}
