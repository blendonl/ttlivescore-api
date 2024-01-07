package com.pek.ttlivescoreapi.league.repository;


import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.transport.LeagueQueryTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

    @Query(value = "select * from league l where l.name like :#{#query.name};", nativeQuery = true)
    List<League> findAllByQuery(@Param("query") LeagueQueryTransport query);

    boolean existsByName(String name);

    @Query(value = "insert into team_league(year, league_id, team_id) values (date_part('year', date(now())),:leagueId, :teamId)", nativeQuery = true)
    void addTeam(long leagueId, long teamId);

    @Modifying
    @Query(value = "delete from team_league tl where tl.team_id = :teamId and tl.league_id = :leagueId", nativeQuery = true)
    void removeTeam(@Param("leagueId") long leagueId, @Param("teamId") long teamId);

    @Query(value = "select case when count(*) = 1 then TRUE else FALSE end from team_league tl where tl.year = :year and tl.league_id = :leagueId and tl.team_id = :teamId", nativeQuery = true)
    boolean teamExists(long leagueId, long teamId, int year);
}