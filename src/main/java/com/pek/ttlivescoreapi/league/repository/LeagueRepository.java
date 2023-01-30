package com.pek.ttlivescoreapi.league.repository;


import com.pek.ttlivescoreapi.league.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends CrudRepository<League, Long> {
}
