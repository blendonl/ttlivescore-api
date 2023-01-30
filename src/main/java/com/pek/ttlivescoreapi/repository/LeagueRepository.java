package com.pek.ttlivescoreapi.repository;


import com.pek.ttlivescoreapi.entity.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends CrudRepository<League, Long> {
}
