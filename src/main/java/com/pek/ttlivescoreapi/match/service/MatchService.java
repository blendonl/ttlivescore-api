package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MatchService {

    MatchTransport findById(long matchId);

    MatchTransport save(MatchTransport matchTransport);

    MatchTransport update(MatchTransport matchTransport);

    void deleteById(long matchId);

    List<MatchTransport> findAllByEventId(long eventId);

    List<MatchTransport> findAllSingleByEventId(long eventId);

    List<MatchTransport> findAllDoubleByEventId(long eventId);

    List<MatchTransport> findALlByPlayer1IdAndPlayer2Id(long player1Id, long player2Id);

    List<MatchTransport> findAllByPlayerId(long playerId);



    UserTransport getWinnerInASingleMatch(long singleMatchId);

    List<MatchTransport> findAll();

}
