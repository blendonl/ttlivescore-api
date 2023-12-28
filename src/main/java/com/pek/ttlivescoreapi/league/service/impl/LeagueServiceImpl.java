package com.pek.ttlivescoreapi.league.service.impl;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.exception.LeagueNotFoundException;
import com.pek.ttlivescoreapi.league.mapper.LeagueMapper;
import com.pek.ttlivescoreapi.league.mapper.LeagueShortMapper;
import com.pek.ttlivescoreapi.league.repository.LeagueRepository;
import com.pek.ttlivescoreapi.league.service.LeagueService;
import com.pek.ttlivescoreapi.league.transport.LeagueQueryTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueShortTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }


    @Override
    public LeagueTransport save(LeagueTransport leagueDto) {

        League league = LeagueMapper.toLeague(leagueDto);

        league = leagueRepository.save(league);

        return LeagueMapper.toLeagueDto(league);
    }

    @Override
    public List<LeagueShortTransport> findAll(LeagueQueryTransport query) {
        if (query == null) {
            return LeagueShortMapper.toLeagueShortTransports(leagueRepository.findAll());
        }

        return LeagueShortMapper.toLeagueShortTransports(leagueRepository.findAllByQuery(query));

    }

    @Override
    public void deleteById(long id) {

        if (!leagueRepository.existsById(id))
            throw new LeagueNotFoundException();

        leagueRepository.deleteById(id);
    }

    @Override
    public LeagueTransport findById(long id) {

        League league = leagueRepository.findById(id).orElseThrow(LeagueNotFoundException::new);

        return LeagueMapper.toLeagueDto(league);

    }
}
