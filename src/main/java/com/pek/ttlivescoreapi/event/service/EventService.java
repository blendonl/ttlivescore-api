package com.pek.ttlivescoreapi.event.service;

import com.pek.ttlivescoreapi.event.transport.EventShortTransport;
import com.pek.ttlivescoreapi.event.transport.EventTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<EventShortTransport> findAll();

    EventTransport findOne(long id);
}
