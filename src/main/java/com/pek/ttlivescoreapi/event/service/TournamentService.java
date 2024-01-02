package com.pek.ttlivescoreapi.event.service;

import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentUpdateTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentService {


    TournamentTransport findById(long id);

    TournamentShortTransport save(TournamentCreateTransport transport);

    List<TournamentShortTransport> findAll();

    TournamentShortTransport update(long id, TournamentUpdateTransport transport);


}
