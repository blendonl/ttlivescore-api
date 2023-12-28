package com.pek.ttlivescoreapi.team.repository;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.tansport.TeamQueryTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByName(String name);

    @Query(value = "Select * from team t where t.league_id = :leagueId", nativeQuery = true)
    List<Team> findAllByLeagueId(long leagueId);

    @Query(value = "select * from team t where t.name = :query.name", nativeQuery = true)
    List<Team> findAllByQuery(TeamQueryTransport query);
}
