package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.match.repository.PointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private PointRepository pointRepository;

    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }


    public List<Point> findAllByMatchIdAndPlayerId(long matchId, long playerId) {
        return pointRepository.findAllByMatchIdAndPlayerId(matchId, playerId);
    }
}
