package com.pek.ttlivescoreapi.match.repository;

import com.pek.ttlivescoreapi.match.entity.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {



    List<Match> findAllByEventId(long eventId);

    @Query(value = "SELECT * from match m inner join public.match_player mp on m.id = mp.match_id where mp.player_id = :playerId", nativeQuery = true)
    List<Match> findAllByPlayerId(long playerId);


    @Query(value = "SELECT * from match m inner join match_player mp on m.id = mp.match_id where mp.player_id = :player1Id and (select match_id from match inner join match_player on match.id = match_player.match_id where mp.player_id = :player2Id)", nativeQuery = true)
    List<Match> findAllByPlayer1IdAndPLayer2Id(long player1Id, long player2Id);


}
