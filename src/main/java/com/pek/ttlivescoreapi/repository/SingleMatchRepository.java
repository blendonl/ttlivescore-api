package com.pek.ttlivescoreapi.repository;

import com.pek.ttlivescoreapi.entity.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleMatchRepository extends CrudRepository<Match, Long> {

    @Query(value = "Select count(*) from users inner join point on users.id = point.player_id where point.single_match_id = :singleMatchId and :playerId = point.player_id", nativeQuery = true)
    int getPlayerPointsSingleMatch(long singleMatchId, long playerId);
//
//
//    List<Match> findAllByPlayer1IdAndPlayer2Id(long player1Id, long player2Id);

}
