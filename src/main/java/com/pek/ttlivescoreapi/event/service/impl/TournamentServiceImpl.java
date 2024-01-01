package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.entity.EventType;
import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.exception.TournamentAlreadyExistException;
import com.pek.ttlivescoreapi.event.exception.TournamentNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.TournamentCreateMapper;
import com.pek.ttlivescoreapi.event.mapper.TournamentMapper;
import com.pek.ttlivescoreapi.event.mapper.TournamentShortMapper;
import com.pek.ttlivescoreapi.event.repository.EventRepository;
import com.pek.ttlivescoreapi.event.repository.TournamentRepository;
import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentTransport;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;
    private final EventRepository eventRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, EventRepository eventRepository) {
        this.tournamentRepository = tournamentRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public TournamentTransport findById(long id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(TournamentNotFoundException::new);

        return TournamentMapper.toTournamentTransport(tournament);
    }

    @Override
    public TournamentShortTransport save(TournamentCreateTransport newTournament) {

        if (this.tournamentRepository.existsByNameAndCategoryName(newTournament.getName(), newTournament.getCategory())) {
            throw new TournamentAlreadyExistException();
        }

        Tournament tournament = TournamentCreateMapper.toTournament(newTournament);

        tournament.getCategory().setId(1L);

        Event event = this.eventRepository.save(Event.builder().name(newTournament.getName()).eventType(EventType.TOURNAMENT).date(new Date(2022)).gender('M').build());

        tournament.setEvent(event);
        tournament.setId(event.getId());

        tournament = this.tournamentRepository.save(tournament);

        return TournamentShortMapper.toTournamentShortTransport(tournament);

    }

    @Override
    public List<TournamentShortTransport> findAll() {
        return null;
    }
}
