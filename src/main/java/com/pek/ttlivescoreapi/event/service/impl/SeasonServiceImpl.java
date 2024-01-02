package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Season;
import com.pek.ttlivescoreapi.event.exception.SeasonNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.SeasonMapper;
import com.pek.ttlivescoreapi.event.repository.SeasonRepository;
import com.pek.ttlivescoreapi.event.service.SeasonService;
import com.pek.ttlivescoreapi.event.transport.SeasonTransport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public SeasonTransport findById(long id) {

        Season season = this.seasonRepository.findById(id).orElseThrow(SeasonNotFoundException::new);

        return SeasonMapper.toSeasonTransport(season);
    }

    @Override
    public SeasonTransport update(SeasonTransport season) {
        return null;
    }

    @Override
    public SeasonTransport save(SeasonTransport season) {
        return null;
    }

    @Override
    public List<SeasonTransport> findAllByLeagueId(long leagueId) {
        return null;
    }

    @Override
    public List<SeasonTransport> finAllByLeagueIdAndYear(long leagueId, int year) {
        return null;
    }
}
