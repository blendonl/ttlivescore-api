package com.pek.ttlivescoreapi.league.repository;


import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueQueryTransport;
import com.pek.ttlivescoreapi.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    @Query(value = "select * from league l where l.name like :#{#query.name}", nativeQuery = true)
    List<League> findAllByQuery(@Param("query") LeagueQueryTransport query);

    boolean existsByName(String name);

    Optional<Team> addTeam(long leagueId, long teamId);

    Optional<Team> removeTeam(long leagueId, long teamId);
}