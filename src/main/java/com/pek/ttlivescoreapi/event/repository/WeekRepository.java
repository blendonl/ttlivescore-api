package com.pek.ttlivescoreapi.event.repository;

import com.pek.ttlivescoreapi.event.entity.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeekRepository extends JpaRepository<Week, Long> {

    @Query(value = "select event_id, season, league_id, l.name league_name, year, category_id, date, event_type, gender, e.name event_name from week w " +
            "left join public.event e on e.id = w.event_id " +
            "left join public.league l on l.id = w.league_id " +
            "where w.league_id = :#{#leagueId} and date_part('year', e.date) = :year", nativeQuery = true)
    List<Week> findAllByLeagueIdAndYear(long leagueId, long year);


    @Query(value = "select event_id, season, league_id, l.name league_name, year, category_id, date, event_type, gender, e.name event_name from week w " +
            "left join public.event e on e.id = w.event_id " +
            "left join public.league l on l.id = w.league_id " +
            "where w.league_id = league_id", nativeQuery = true)
    List<Week> findAllByLeagueId(long leagueId);
}
