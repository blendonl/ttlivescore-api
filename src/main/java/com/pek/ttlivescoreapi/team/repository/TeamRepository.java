package com.pek.ttlivescoreapi.team.repository;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.tansport.TeamQueryTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String name);

    @Query(value = "Select t.id, t.name, league_id, l.category, l.is_active, l.name, l.year from team t left join team_league tl on tl.team_id = t.id left join league l on l.id = tl.league_id where tl.league_id = :leagueId", nativeQuery = true)
    List<Team> findAllByLeagueId(long leagueId);

    @Query(value = "select * from team t where t.name = :#{#query.name}", nativeQuery = true)
    List<Team> findAllByQuery(@Param("query") TeamQueryTransport query);

    @Query(value = "select * from team", nativeQuery = true)
    Optional<Team> findByIdAndLeagueId(long leagueId, long teamId);

}
