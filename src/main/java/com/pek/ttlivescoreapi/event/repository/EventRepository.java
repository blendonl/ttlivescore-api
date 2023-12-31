package com.pek.ttlivescoreapi.event.repository;

import com.pek.ttlivescoreapi.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
