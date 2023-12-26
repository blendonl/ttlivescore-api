package com.pek.ttlivescoreapi.match.service.impl;

import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.match.mapper.PointMapper;
import com.pek.ttlivescoreapi.match.repository.PointRepository;
import com.pek.ttlivescoreapi.match.service.PointService;
import com.pek.ttlivescoreapi.match.transport.PointTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    private PointRepository pointRepository;

    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }


    @Override
    public int findAllByMatchIdAndPlayerId(long matchId, long playerId) {
        return pointRepository.findAllByMatchIdAndPlayerId(matchId, playerId).size();
    }

    @Override
    public PointTransport save(PointTransport pointTransport) {

        Point point = PointMapper.toPoint(pointTransport);

        point = pointRepository.save(point);

        return PointMapper.toPointTransport(point);
    }

    @Override
    public List<PointTransport> findAllByMatchId(long matchId) {
        return PointMapper.toPointsTransport(pointRepository.findAllByMatchId(matchId));
    }
}
