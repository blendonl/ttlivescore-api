package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.transport.MatchCreateTransport;
import com.pek.ttlivescoreapi.match.transport.MatchShortTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.MatchUpdateTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;

import java.util.List;


public interface MatchService {

    MatchTransport findById(long matchId);

    MatchShortTransport save(MatchCreateTransport newMatch);

    MatchShortTransport update(long matchId, MatchUpdateTransport newMatch);

    void deleteById(long matchId);

    List<MatchTransport> findAllByEventId(long eventId);

    List<MatchTransport> findAllSingleByEventId(long eventId);

    List<MatchTransport> findAllDoubleByEventId(long eventId);

    List<MatchTransport> findALlByPlayer1IdAndPlayer2Id(long player1Id, long player2Id);

    List<MatchTransport> findAllByPlayerId(long playerId);


    UserTransport getWinnerInASingleMatch(long singleMatchId);

    List<MatchShortTransport> findAll();

}
