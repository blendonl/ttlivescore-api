package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.exception.EventNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.EventMapper;
import com.pek.ttlivescoreapi.event.mapper.EventShortMapper;
import com.pek.ttlivescoreapi.event.repository.EventRepository;
import com.pek.ttlivescoreapi.event.service.EventService;
import com.pek.ttlivescoreapi.event.transport.EventShortTransport;
import com.pek.ttlivescoreapi.event.transport.EventTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<EventShortTransport> findAll() {
        return EventShortMapper.toEventShortsTransport(this.eventRepository.findAll());
    }

    @Override
    public EventTransport findOne(long id) {
        Event event = this.eventRepository.findById(id).orElseThrow(EventNotFoundException::new);

        return EventMapper.toEventTransport(event);
    }

}
