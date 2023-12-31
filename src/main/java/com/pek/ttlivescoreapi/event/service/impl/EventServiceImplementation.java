package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.mapper.EventShortMapper;
import com.pek.ttlivescoreapi.event.repository.EventRepository;
import com.pek.ttlivescoreapi.event.service.EventService;
import com.pek.ttlivescoreapi.event.transport.EventShortTransport;
import com.pek.ttlivescoreapi.event.transport.EventTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImplementation(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<EventShortTransport> findAll() {
        return EventShortMapper.toEventShortsTransport(this.eventRepository.findAll());
    }

    @Override
    public EventTransport findOne(long id) {
        return null;
    }

}
