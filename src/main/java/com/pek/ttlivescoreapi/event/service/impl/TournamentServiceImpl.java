package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.entity.EventType;
import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.exception.EventAlreadyExistException;
import com.pek.ttlivescoreapi.event.exception.TournamentAlreadyExistException;
import com.pek.ttlivescoreapi.event.exception.TournamentNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.TournamentMapper;
import com.pek.ttlivescoreapi.event.mapper.TournamentShortMapper;
import com.pek.ttlivescoreapi.event.repository.EventRepository;
import com.pek.ttlivescoreapi.event.repository.TournamentRepository;
import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.*;
import com.pek.ttlivescoreapi.match.entity.Match;
import com.pek.ttlivescoreapi.match.exception.MatchNotFoundException;
import com.pek.ttlivescoreapi.match.mapper.MatchMapper;
import com.pek.ttlivescoreapi.match.mapper.MatchShortMapper;
import com.pek.ttlivescoreapi.match.repository.MatchRepository;
import com.pek.ttlivescoreapi.match.transport.MatchShortTransport;
import com.pek.ttlivescoreapi.match.transport.MatchTransport;
import com.pek.ttlivescoreapi.user.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;
    private final EventRepository eventRepository;
//    private final CategoryRepository categoryRepository;

    private final MatchRepository matchRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository, EventRepository eventRepository, MatchRepository matchRepository) {
        this.tournamentRepository = tournamentRepository;
        this.eventRepository = eventRepository;
//        this.categoryRepository = categoryRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public TournamentTransport findById(long id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(TournamentNotFoundException::new);

        return TournamentMapper.toTournamentTransport(tournament);
    }

    @Override
    public TournamentShortTransport save(TournamentCreateTransport newTournament) {

//        Category category = this.categoryRepository.findByName(newTournament.getCategory()).orElseThrow(CategoryNotFoundException::new);

        Category category = Category.valueOf(newTournament.getCategory().toUpperCase());

        if (this.tournamentRepository.existsByNameAndCategoryName(newTournament.getName(), newTournament.getCategory())) {
            throw new TournamentAlreadyExistException();
        }

        Event event = Event.builder()
                .eventType(EventType.TOURNAMENT)
                .name(newTournament.getName())
                .gender(newTournament.getGender()).date(newTournament.getDate())
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
    public List<TournamentShortTransport> findAll(TournamentQueryTransport query) {

        if (query.getYear() == 0 && !Character.isAlphabetic(query.getGender())) {
            return TournamentShortMapper.toTournamentShortsTransport(this.tournamentRepository.findAll());
        }

        if (!Character.isAlphabetic(query.getGender())) {
            query.setGender(' ');
        }

        return TournamentShortMapper.toTournamentShortsTransport(this.tournamentRepository.findAllByQuery(query));
    }

    @Override
    public List<MatchShortTransport> findAllTournamentMatches(long tournamentId) {

        if (!this.tournamentRepository.existsById(tournamentId)) {
            throw new TournamentNotFoundException();
        }

        return MatchShortMapper.toMatchShortsTransport(this.matchRepository.findAllByTournamentId(tournamentId));
    }

    @Override
    public MatchTransport findMatchByTournamentIdAndMatchId(long tournamentId, long matchId) {

        if (!this.tournamentRepository.existsById(tournamentId)) {
            throw new TournamentNotFoundException();
        }

        Match match = this.matchRepository.findByTournamentIdAndMatchId(tournamentId, matchId).orElseThrow(MatchNotFoundException::new);

        return MatchMapper.toMatchTransport(match);

    }


    @Override
    public TournamentShortTransport update(long id, TournamentUpdateTransport transport) {

        Tournament tournament = this.tournamentRepository.findById(id).orElseThrow(TournamentNotFoundException::new);

        if (this.tournamentRepository.existsByNameAndCategoryName(transport.getName(), tournament.getCategory().name())) {
            throw new TournamentAlreadyExistException();
        }

        if (this.eventRepository.existsByDateAndCategory(transport.getDate(), tournament.getEvent().getGender())) {
            throw new EventAlreadyExistException("There is already an event in that date for this category");
        }

        tournament.getEvent().setName(transport.getName());
        tournament.getEvent().setDate(transport.getDate());

        this.eventRepository.save(tournament.getEvent());

        return TournamentShortMapper.toTournamentShortTransport(tournament);
    }

    @Override
    public void deleteById(long id) {

        if (!this.tournamentRepository.existsById(id)) {
            throw new TournamentNotFoundException();
        }
        this.tournamentRepository.deleteById(id);
    }
}
