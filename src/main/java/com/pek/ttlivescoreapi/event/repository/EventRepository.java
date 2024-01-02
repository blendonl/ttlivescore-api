package com.pek.ttlivescoreapi.event.repository;

import com.pek.ttlivescoreapi.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "select case when count(*) = 1 then True else False end from event where date = :date and gender = :gender", nativeQuery = true)
    boolean existsByDateAndCategory(Date date, char gender);
}
