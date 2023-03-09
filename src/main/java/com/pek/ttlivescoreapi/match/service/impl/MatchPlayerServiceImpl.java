package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.event.repository.MatchPlayerRepository;
import com.pek.ttlivescoreapi.match.entity.MatchPlayer;
import com.pek.ttlivescoreapi.match.service.MatchPlayerService;

import java.util.List;

public class MatchPlayerServiceImpl implements MatchPlayerService {

    private MatchPlayerRepository matchPlayerRepository;


    public MatchPlayerServiceImpl(MatchPlayerRepository matchPlayerRepository) {
        this.matchPlayerRepository = matchPlayerRepository;
    }

    @Override
    public List<MatchPlayer> findAllByMatchId(long matchId) {
        return matchPlayerRepository.findAllByMatchId(matchId);
    }
}
