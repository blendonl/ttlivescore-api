package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.exception.TournamentAlreadyExistException;
import com.pek.ttlivescoreapi.event.exception.TournamentNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.TournamentCreateMapper;
import com.pek.ttlivescoreapi.event.mapper.TournamentMapper;
import com.pek.ttlivescoreapi.event.mapper.TournamentShortMapper;
import com.pek.ttlivescoreapi.event.repository.TournamentRepository;
import com.pek.ttlivescoreapi.event.service.TournamentService;
import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;
import com.pek.ttlivescoreapi.event.transport.TournamentTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {
    private final TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
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

        return TournamentShortMapper.toTournamentShortTransport(this.tournamentRepository.save(tournament));

    }

    @Override
    public List<TournamentShortTransport> findAll() {
        return null;
    }
}
