package com.pek.ttlivescoreapi.league.service.impl;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.exception.CategoryNotFoundException;
import com.pek.ttlivescoreapi.league.exception.LeagueAlreadyExistException;
import com.pek.ttlivescoreapi.league.exception.LeagueNotFoundException;
import com.pek.ttlivescoreapi.league.mapper.LeagueCreateMapper;
import com.pek.ttlivescoreapi.league.mapper.LeagueMapper;
import com.pek.ttlivescoreapi.league.mapper.LeagueShortMapper;
import com.pek.ttlivescoreapi.league.repository.CategoryRepository;
import com.pek.ttlivescoreapi.league.repository.LeagueRepository;
import com.pek.ttlivescoreapi.league.service.LeagueService;
import com.pek.ttlivescoreapi.league.transport.LeagueCreateTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueQueryTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueShortTransport;
import com.pek.ttlivescoreapi.league.transport.LeagueTransport;
import com.pek.ttlivescoreapi.user.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;
    private final CategoryRepository categoryRepository;


    public LeagueServiceImpl(LeagueRepository leagueRepository, CategoryRepository categoryRepository) {
        this.leagueRepository = leagueRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public LeagueShortTransport save(LeagueCreateTransport newLeague) {
        Category category = this.categoryRepository.findByName(newLeague.getCategory());

        if (category == null) {
            throw new CategoryNotFoundException();
        }

        if (this.leagueRepository.existsByName(newLeague.getName())) {
            throw new LeagueAlreadyExistException();
        }

        League league = LeagueCreateMapper.toLeague(newLeague);

        league.setCategory(category);

        league = leagueRepository.save(league);

        return LeagueShortMapper.toLeagueShortTransport(league);
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

        return LeagueMapper.toLeagueTransport(league);

    }
}
