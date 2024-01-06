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

    @Query(value = "select * from league l where l.name like :#{#query.name};", nativeQuery = true)
    List<League> findAllByQuery(@Param("query") LeagueQueryTransport query);

    boolean existsByName(String name);

    @Query(value = "insert into team_league(year, league_id, team_id) values (date_part('year', date(now())),:leagueId, :teamId); select * from team where team.id = :teamId", nativeQuery = true)
    void addTeam(long leagueId, long teamId);

    @Query(value = "update team set id = :teamId where league_id = -1;", nativeQuery = true)
    Optional<Team> removeTeam(long teamId);

    @Query(value = "select case when count(*) = 1 then TRUE else FALSE end from team_league tl where tl.year = :year and tl.league_id = :leagueId and tl.team_id = :teamId", nativeQuery = true)
    boolean teamExists(long leagueId, long teamId, int year);
}