package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.exception.MatchInvalidPlayersException;
import com.pek.ttlivescoreapi.match.exception.MatchNotFoundException;
import com.pek.ttlivescoreapi.match.mapper.MatchCreateMapper;
import com.pek.ttlivescoreapi.match.mapper.MatchMapper;
import com.pek.ttlivescoreapi.match.mapper.MatchShortMapper;
import com.pek.ttlivescoreapi.match.mapper.MatchUpdateMapper;
import com.pek.ttlivescoreapi.match.repository.MatchRepository;
import com.pek.ttlivescoreapi.match.service.MatchService;
import com.pek.ttlivescoreapi.match.service.PointService;
import com.pek.ttlivescoreapi.match.transport.MatchCreateTransport;
import com.pek.ttlivescoreapi.match.transport.MatchShortTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.match.transport.MatchUpdateTransport;
import com.pek.ttlivescoreapi.user.exception.UserNotFoundException;
import com.pek.ttlivescoreapi.user.repository.UserRepository;
import com.pek.ttlivescoreapi.user.transport.UserTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final PointService pointService;
    private final UserRepository userRepository;

    public MatchServiceImpl(MatchRepository matchRepository, PointService pointService, UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.pointService = pointService;
        this.userRepository = userRepository;
    }

    @Override
    public MatchTransport findById(long matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);

        return MatchMapper.toMatchTransport(match);
    }

    @Override
    public MatchShortTransport save(MatchCreateTransport newMatch) {

        if (newMatch.getPlayers().isEmpty()) {
            throw new MatchInvalidPlayersException();
        }

        newMatch.getPlayers().forEach(pl -> {
            if (!this.userRepository.existsByEmail(pl.getPlayer1Email())) {
                throw new UserNotFoundException("player 1 not found");
            }

            if (pl.getPlayer2Email() == null || !this.userRepository.existsByEmail(pl.getPlayer2Email())) {
                throw new UserNotFoundException("player 2 not found");
            }
        });


        Match match = MatchCreateMapper.toMatch(newMatch);
        match = matchRepository.save(match);

        return MatchShortMapper.toMatchShortTransport(match);
    }

    @Override
    public MatchShortTransport update(long matchId, MatchUpdateTransport newMatch) {

        if (!this.userRepository.existsById(newMatch.getRefereeId())) {
            throw new UserNotFoundException("referee doesnt exist");
        }

        Match match = MatchUpdateMapper.toMatch(newMatch);
        match.setId(matchId);

        match = matchRepository.save(match);

        return MatchShortMapper.toMatchShortTransport(match);
    }

    @Override
    public void deleteById(long matchId) {
        if (!matchRepository.existsById(matchId))
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
    public List<MatchTransport> findAllByPlayerId(long playerId) {

        return MatchMapper.toMatchTransports(this.matchRepository.findAllByPlayerId(playerId));

    }

    @Override
    public UserTransport getWinnerInASingleMatch(long singleMatchId) {

//        List<MatchPlayerTransport> players = matchPlayerService.findAllByMatchId(singleMatchId);
//
//        int player1Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(0).getPlayerId());
//        int player2Points = pointService.findAllByMatchIdAndPlayerId(singleMatchId, players.get(1).getPlayerId());
//
//        if(player1Points > player2Points) {
//            return null;
//        }

        return null;

    }

    @Override
    public List<MatchShortTransport> findAll() {

        return MatchShortMapper.toMatchShortsTransport(matchRepository.findAll());
    }
}
