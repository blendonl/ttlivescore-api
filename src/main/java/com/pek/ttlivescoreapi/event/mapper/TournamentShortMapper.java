package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;

import java.util.List;

public class TournamentShortMapper {

    public static List<TournamentShortTransport> toTournamentShortsTransport(List<Tournament> tournaments) {
        return tournaments.stream().map(TournamentShortMapper::toTournamentShortTransport).toList();
    }

    public static TournamentShortTransport toTournamentShortTransport(Tournament tournament) {
        return TournamentShortTransport.builder()
                .id(tournament.getId())
                .date(tournament.getEvent().getDate())
                .name(tournament.getEvent().getName())
                .category(tournament.getCategory().name())
                .build();

    }
}
