package com.pek.ttlivescoreapi.service.impl;

import com.pek.ttlivescoreapi.config.exception.LeagueNotFoundException;
import com.pek.ttlivescoreapi.dto.LeagueDto;
import com.pek.ttlivescoreapi.entity.League;
import com.pek.ttlivescoreapi.mapper.LeagueMapper;
import com.pek.ttlivescoreapi.repository.LeagueRepository;
import com.pek.ttlivescoreapi.service.LeagueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    private LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }


    @Override
    public LeagueDto save(LeagueDto leagueDto) {

        League league = LeagueMapper.toLeague(leagueDto);

        league = leagueRepository.save(league);

        return LeagueMapper.toLeagueDto(league);
    }

    @Override
    public List<LeagueDto> findAll() {
        List<League> leagues = (List<League>) leagueRepository.findAll();
        return LeagueMapper.toLeaguesDto(leagues);
    }

    @Override
    public void deleteById(long id) {

        if(!leagueRepository.existsById(id))
            throw new LeagueNotFoundException();

        leagueRepository.deleteById(id);
    }
}
