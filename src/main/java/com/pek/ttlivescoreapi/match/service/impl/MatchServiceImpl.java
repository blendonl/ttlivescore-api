package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.match.repository.MatchRepository;
import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.exception.MatchNotFoundException;
import com.pek.ttlivescoreapi.match.mapper.MatchMapper;
import com.pek.ttlivescoreapi.match.service.MatchPlayerService;
import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.service.PointService;
import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;
    private MatchPlayerService matchPlayerService;
    private PointService pointService;

    public MatchServiceImpl(MatchRepository matchRepository, MatchPlayerService matchPlayerService, PointService pointService) {
        this.matchRepository = matchRepository;
        this.matchPlayerService = matchPlayerService;
        this.pointService = pointService;
    }

    @Override
    public MatchTransport findById(long matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);
        return MatchMapper.toMatchTransport(match);
    }

    @Override
    public MatchTransport save(MatchTransport matchTransport) {
        Match match = MatchMapper.toMatch(matchTransport);
        match = matchRepository.save(match);
        return MatchMapper.toMatchTransport(match);
    }

    @Override
    public MatchTransport update(MatchTransport matchTransport) {
        Match match = MatchMapper.toMatch(matchTransport);
        match = matchRepository.save(match);
        return MatchMapper.toMatchTransport(match);
    }

    @Override
    public void deleteById(long matchId) {

        if(!matchRepository.existsById(matchId))
            throw new MatchNotFoundException();

        matchRepository.deleteById(matchId);
    }

    @Override
    public List<MatchTransport> findAllByEventId(long eventId) {
        return MatchMapper.toMatchTransports(matchRepository.findAllByEventId(eventId));
    }

    @Override
    public List<MatchTransport> findAllSingleByEventId(long eventId) {
        return null;
    }

    @Override
    public List<MatchTransport> findAllDoubleByEventId(long eventId) {
        return null;
    }

    @Override
    public List<MatchTransport> findALlByPlayer1IdAndPlayer2Id(long player1Id, long player2Id) {
        return MatchMapper.toMatchTransports(matchRepository.findAllByPlayer1IdAndPLayer2Id(player1Id, player2Id));
    }

    @Override
    public UserTransport getWinnerInASingleMatch(long singleMatchId) {

        List<MatchPlayerTransport> players = matchPlayerService.findAllByMatchId(singleMatchId);

        int player1Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(0).getPlayer().getId());
        int player2Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(1).getPlayer().getId());

        if(player1Points > player2Points) {
            return (players.get(0).getPlayer());
        }

        return players.get(1).getPlayer();
    }
}
