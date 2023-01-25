package com.pek.ttlivescoreapi.repository;

import com.pek.ttlivescoreapi.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Optional<Team> findByName(String name);

    @Query(value = "Select * from team t where t.league_id = :leagueId", nativeQuery = true)
    List<Team> findAllByLeagueId(long leagueId);
}
