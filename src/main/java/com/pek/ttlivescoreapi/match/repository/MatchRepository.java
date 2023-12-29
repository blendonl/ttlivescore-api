package com.pek.ttlivescoreapi.match.repository;

import com.pek.ttlivescoreapi.match.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {


    List<Match> findAllByEventId(long eventId);


    @Query(value = "SELECT m from Match m " +
            "inner join fetch m.players g " +
            "where g.player1.id = :player1Id and :player2Id = (select g1.player1.id from Group g1 where g1.match.id = g.match.id and g1.player1.id != :player1Id) " +
            "or g.player1.id = :player2Id and :player1Id = (select g2.player1.id from Group g2 where g2.match.id = g.match.id and g2.player1.id != :player2Id)")
    List<Match> findAllByPlayer1IdAndPLayer2Id(long player1Id, long player2Id);


    @Query(value = "SELECT m from Match m inner join Group g on m.id = g.match.id where g.player1.id = :playerId or g.player2.id = :playerId")
    List<Match> findAllByPlayerId(long playerId);


}
