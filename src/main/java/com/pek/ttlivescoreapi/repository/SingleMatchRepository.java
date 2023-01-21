package com.pek.ttlivescoreapi.repository;

import com.pek.ttlivescoreapi.entity.SingleMatch;
import com.pek.ttlivescoreapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingleMatchRepository extends CrudRepository<SingleMatch, Long> {

    @Query(value = "Select count(*) from users inner join point on users.id = point.player_id where point.single_match_id = :singleMatchId and :playerId = point.player_id", nativeQuery = true)
    int getPlayerPointsSingleMatch(long singleMatchId, long playerId);




}
