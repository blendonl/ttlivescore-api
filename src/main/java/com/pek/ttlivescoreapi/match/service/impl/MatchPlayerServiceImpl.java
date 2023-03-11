package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.match.repository.MatchPlayerRepository;
import com.pek.ttlivescoreapi.match.mapper.MatchPlayerMapper;
import com.pek.ttlivescoreapi.match.service.MatchPlayerService;
import com.pek.ttlivescoreapi.match.transport.MatchPlayerTransport;

import java.util.List;

public class MatchPlayerServiceImpl implements MatchPlayerService {

    private MatchPlayerRepository matchPlayerRepository;


    public MatchPlayerServiceImpl(MatchPlayerRepository matchPlayerRepository) {
        this.matchPlayerRepository = matchPlayerRepository;
    }

    @Override
    public List<MatchPlayerTransport> findAllByMatchId(long matchId) {
        return MatchPlayerMapper.toMatchPlayerTransports(matchPlayerRepository.findAllByMatchId(matchId));
    }
}
