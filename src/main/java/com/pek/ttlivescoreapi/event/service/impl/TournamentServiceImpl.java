package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.entity.EventType;
import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.exception.TournamentAlreadyExistException;
import com.pek.ttlivescoreapi.event.exception.TournamentNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.TournamentMapper;
import com.pek.ttlivescoreapi.event.mapper.TournamentShortMapper;
import com.pek.ttlivescoreapi.event.repository.EventRepository;
import com.pek.ttlivescoreapi.event.repository.TournamentRepository;
import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentTransport;
import com.pek.ttlivescoreapi.league.exception.CategoryNotFoundException;
import com.pek.ttlivescoreapi.league.repository.CategoryRepository;
import com.pek.ttlivescoreapi.user.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;
    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, EventRepository eventRepository, CategoryRepository categoryRepository) {
        this.tournamentRepository = tournamentRepository;
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public TournamentTransport findById(long id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(TournamentNotFoundException::new);

        return TournamentMapper.toTournamentTransport(tournament);
    }

    @Override
    public TournamentShortTransport save(TournamentCreateTransport newTournament) {

        Category category = this.categoryRepository.findByName(newTournament.getCategory()).orElseThrow(CategoryNotFoundException::new);


        if (this.tournamentRepository.existsByNameAndCategoryName(newTournament.getName(), newTournament.getCategory())) {
            throw new TournamentAlreadyExistException();
        }

        Event event = Event.builder()
                .eventType(EventType.TOURNAMENT)
                .name(newTournament.getName())
                .gender(newTournament.getGender())
                .date(newTournament.getDate())
                .build();


        event = this.eventRepository.save(event);

        Tournament tournament = Tournament.builder()
                .id(event.getId())
                .event(event)
                .category(category)
                .build();

        tournament = this.tournamentRepository.save(tournament);

        return TournamentShortMapper.toTournamentShortTransport(tournament);

    }

    @Override
    public List<TournamentShortTransport> findAll() {
        return null;
    }
}
