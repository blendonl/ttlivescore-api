package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.match.repository.PointRepository;
import com.pek.ttlivescoreapi.match.service.PointService;

public class PointServiceImpl implements PointService {
    private PointRepository pointRepository;

    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }


    @Override
    public int findAllByMatchIdAndPlayerId(long matchId, long playerId) {
        return pointRepository.findAllByMatchIdAndPlayerId(matchId, playerId).size();
    }
}
