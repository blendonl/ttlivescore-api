package com.pek.ttlivescoreapi.repository;

import com.pek.ttlivescoreapi.entity.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends CrudRepository<Point, Long> {

    List<Point> findAllByMatchIdAndPlayerId(long matchId, long playerId);
}
