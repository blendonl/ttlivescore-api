package com.pek.ttlivescoreapi.league.service.impl;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.exception.LeagueAlreadyExistException;
import com.pek.ttlivescoreapi.league.exception.LeagueNotFoundException;
import com.pek.ttlivescoreapi.league.mapper.LeagueCreateMapper;
import com.pek.ttlivescoreapi.league.mapper.LeagueMapper;
import com.pek.ttlivescoreapi.league.mapper.LeagueShortMapper;
import com.pek.ttlivescoreapi.league.repository.LeagueRepository;
import com.pek.ttlivescoreapi.league.service.LeagueService;
import com.pek.ttlivescoreapi.league.transport.*;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.exception.TeamNotFoundException;
import com.pek.ttlivescoreapi.team.mapper.TeamShortMapper;
import com.pek.ttlivescoreapi.team.repository.TeamRepository;
import com.pek.ttlivescoreapi.team.tansport.TeamShortTransport;
import com.pek.ttlivescoreapi.user.entity.Category;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;
    //    private final CategoryRepository categoryRepository;
    private final TeamRepository teamRepository;


    public LeagueServiceImpl(LeagueRepository leagueRepository, TeamRepository teamRepository) {
        this.leagueRepository = leagueRepository;
//        this.categoryRepository = categoryRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    public LeagueShortTransport save(LeagueCreateTransport newLeague) {
//        Category category = this.categoryRepository.findByName(newLeague.getCategory()).orElseThrow(CategoryNotFoundException::new);

        Category category = Category.valueOf(newLeague.getCategory().toUpperCase());

        if (this.leagueRepository.existsByName(newLeague.getName())) {
            throw new LeagueAlreadyExistException();
        }

        League league = LeagueCreateMapper.toLeague(newLeague);

        league.setCategory(category);

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(Date.from(Instant.now()));
        league.setYear(calendar.get(Calendar.YEAR));

        league = leagueRepository.save(league);

        return LeagueShortMapper.toLeagueShortTransport(league);
    }

    @Override
    public List<LeagueShortTransport> findAll(LeagueQueryTransport query) {
        if (query.getName() == null || !Character.isAlphabetic(query.getGender())) {
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

    @Override
    public LeagueShortTransport update(long id, LeagueUpdateTransport newLeague) {
        League league = this.leagueRepository.findById(id).orElseThrow(LeagueNotFoundException::new);

        league.setName(newLeague.getName());

        return LeagueShortMapper.toLeagueShortTransport(league);

    }

    @Override
    public List<TeamShortTransport> findAllTeams(long leagueId) {

        if (!this.leagueRepository.existsById(leagueId)) {
            throw new LeagueNotFoundException();
        }

        return TeamShortMapper.toTeamsShort(this.teamRepository.findAllByLeagueId(leagueId));


    }

    @Override
    public TeamShortTransport findOneTeamById(long leagueId, long teamId) {

        if (!this.leagueRepository.existsById(leagueId)) {
            throw new LeagueNotFoundException();
        }

        Team team = this.teamRepository.findByIdAndLeagueId(leagueId, teamId).orElseThrow(TeamNotFoundException::new);

        return TeamShortMapper.toTeamShort(team);
    }

    @Override
    public TeamShortTransport addTeam(long leagueId, AddTeamToLeagueTransport newTeam) {
        if (!this.leagueRepository.existsById(leagueId)) {
            throw new LeagueNotFoundException();
        }


        Team team = this.leagueRepository.addTeam(leagueId, newTeam.getId()).orElseThrow(TeamNotFoundException::new);

        return TeamShortMapper.toTeamShort(team);

    }

    @Override
    public TeamShortTransport removeTeam(long leagueId, long teamId) {
        if (!this.leagueRepository.existsById(leagueId)) {
            throw new LeagueNotFoundException();
        }

        Team team = this.leagueRepository.removeTeam(teamId).orElseThrow(TeamNotFoundException::new);

        return TeamShortMapper.toTeamShort(team);
    }


}
