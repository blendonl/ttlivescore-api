package com.pek.ttlivescoreapi.event.controller;

import com.pek.ttlivescoreapi.event.service.EventService;
import com.pek.ttlivescoreapi.event.transport.EventShortTransport;
import com.pek.ttlivescoreapi.event.transport.EventTransport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public List<EventShortTransport> findAll() {
        return this.eventService.findAll();
    }

    @GetMapping("{eventId}")
    public EventTransport findOne(@PathVariable long eventId) {
        return this.eventService.findOne(eventId);
    }
}
