package com.pek.ttlivescoreapi.event.service;

import com.pek.ttlivescoreapi.event.transport.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TournamentService {


    TournamentTransport findById(long id);

    TournamentShortTransport save(TournamentCreateTransport transport);

    List<TournamentShortTransport> findAll(TournamentQueryTransport query);

    TournamentShortTransport update(long id, TournamentUpdateTransport transport);

    void deleteById(long id);


}
