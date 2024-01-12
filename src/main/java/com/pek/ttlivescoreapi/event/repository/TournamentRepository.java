package com.pek.ttlivescoreapi.event.repository;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.transport.TournamentQueryTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    @Query(value = "select * from tournament t left join event e on t.event_id = e.id where date_part('year', date) = :#{#query.year} or gender = :#{#query.gender}", nativeQuery = true)
    List<Tournament> findAllByQuery(@Param("query") TournamentQueryTransport query);

    @Query(value = "select case when count(*) = 1 then True else False end from event e left join tournament t on e.id = t.event_id where e.name = :name and category = :category", nativeQuery = true)
    boolean existsByNameAndCategoryName(String name, String category);
}
