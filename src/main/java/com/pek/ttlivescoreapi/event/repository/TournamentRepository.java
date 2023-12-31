package com.pek.ttlivescoreapi.event.repository;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
