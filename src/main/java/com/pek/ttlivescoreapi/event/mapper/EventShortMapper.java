package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.transport.EventShortTransport;

import java.util.List;

public class EventShortMapper {

    public static EventShortTransport toEventShortTransport(Event event) {
        return EventShortTransport.builder()
                .id(event.getId())
                .date(event.getDate())
                .name(event.getName())
                .gender(event.getGender())
                .build();

    }

    public static List<EventShortTransport> toEventShortsTransport(List<Event> events) {
        return events
                .stream()
                .map(EventShortMapper::toEventShortTransport)
                .toList();

    }
}
