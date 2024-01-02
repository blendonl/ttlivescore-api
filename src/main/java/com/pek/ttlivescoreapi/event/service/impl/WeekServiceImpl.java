package com.pek.ttlivescoreapi.event.service.impl;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.entity.EventType;
import com.pek.ttlivescoreapi.event.entity.SeasonType;
import com.pek.ttlivescoreapi.event.entity.Week;
import com.pek.ttlivescoreapi.event.exception.WeekAlreadyExistException;
import com.pek.ttlivescoreapi.event.exception.WeekNotFoundException;
import com.pek.ttlivescoreapi.event.mapper.WeekMapper;
import com.pek.ttlivescoreapi.event.mapper.WeekShortMapper;
import com.pek.ttlivescoreapi.event.repository.EventRepository;
import com.pek.ttlivescoreapi.event.repository.WeekRepository;
import com.pek.ttlivescoreapi.event.service.WeekService;
import com.pek.ttlivescoreapi.event.transport.WeekCreateTransport;
import com.pek.ttlivescoreapi.event.transport.WeekShortTransport;
import com.pek.ttlivescoreapi.event.transport.WeekTransport;
import com.pek.ttlivescoreapi.event.transport.WeekUpdateTransport;
import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.league.exception.LeagueNotFoundException;
import com.pek.ttlivescoreapi.league.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekServiceImpl implements WeekService {
    private final WeekRepository weekRepository;
    private final EventRepository eventRepository;
    private final LeagueRepository leagueRepository;

    public WeekServiceImpl(WeekRepository weekRepository, EventRepository eventRepository, LeagueRepository leagueRepository) {
        this.weekRepository = weekRepository;
        this.eventRepository = eventRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    public WeekTransport findById(long id) {
        Week week = this.weekRepository.findById(id).orElseThrow(WeekNotFoundException::new);

        return WeekMapper.toWeekTransport(week);
    }

    @Override
    public List<WeekShortTransport> findAll() {
        return WeekShortMapper.toWeekShortsTransport(this.weekRepository.findAll());
    }

    @Override
    public WeekShortTransport save(WeekCreateTransport newSeason) {

        if (this.eventRepository.existsByName(newSeason.getName())) {
            throw new WeekAlreadyExistException();
        }

        SeasonType season = SeasonType.valueOf(newSeason.getSeason());

        System.out.println(season);

        League league = this.leagueRepository.findById(newSeason.getLeagueId()).orElseThrow(LeagueNotFoundException::new);


        Event event = Event.builder()
                .eventType(EventType.WEEK)
                .name(newSeason.getName())
                .gender(newSeason.getGender())
                .date(newSeason.getDate())
                .build();


        event = this.eventRepository.save(event);

        Week week = Week.builder()
                .id(event.getId())
                .event(event)
                .league(league)
                .season(season)
                .build();

        return WeekShortMapper.toWeekShortTransport(this.weekRepository.save(week));
    }

    @Override
    public List<WeekShortTransport> findAllByLeagueId(long leagueId) {
        return null;
    }

    @Override
    public List<WeekShortTransport> finAllByLeagueIdAndYear(long leagueId, int year) {
        return null;
    }

    @Override
    public WeekShortTransport update(long id, WeekUpdateTransport newWeek) {

        Week week = this.weekRepository.findById(id).orElseThrow(WeekNotFoundException::new);

        week.getEvent().setDate(newWeek.getDate());

        return WeekShortMapper.toWeekShortTransport(this.weekRepository.save(week));
    }

}
