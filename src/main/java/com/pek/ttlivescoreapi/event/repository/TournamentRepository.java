package com.pek.ttlivescoreapi.event.repository;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    @Query(value = "select case when count(*) = 1 then True else False end from event e left join tournament t on e.id = t.event_id left join category c on c.id = t.category_id where e.name = :name and c.name = :category", nativeQuery = true)
    boolean existsByNameAndCategoryName(String name, String category);
}
