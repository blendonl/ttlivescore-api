package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.transport.EventTransport;

public class EventMapper {

    public static EventTransport toEventTransport(Event event) {
        return EventTransport.builder()
                .name(event.getName())
                .date(event.getDate())
                .id(event.getId())
                .type(event.getClass().getName())
                .build();
    }
}
