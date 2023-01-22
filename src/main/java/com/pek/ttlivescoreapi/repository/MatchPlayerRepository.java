package com.pek.ttlivescoreapi.repository;

import com.pek.ttlivescoreapi.entity.MatchPlayer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchPlayerRepository extends CrudRepository<MatchPlayer, Long> {

    List<MatchPlayer> findAllByMatchId(long matchId);


    @Query(value = "select doubles from match_player where match_id = :matchId", nativeQuery = true)
    boolean isSingleByMatchId(long matchId);
}
