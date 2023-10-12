package com.pek.ttlivescoreapi.match.service;

import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.match.transport.PointTransport;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PointService {
    int findAllByMatchIdAndPlayerId(long matchId, long playerId);

    PointTransport save(PointTransport point);

    List<PointTransport> findAllByMatchId(long matchId);

}
