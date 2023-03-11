package com.pek.ttlivescoreapi.match.repository;

import com.pek.ttlivescoreapi.match.entity.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<Point, Long> {

    List<Point> findAllByMatchIdAndPlayerId(long matchId, long playerId);
}
