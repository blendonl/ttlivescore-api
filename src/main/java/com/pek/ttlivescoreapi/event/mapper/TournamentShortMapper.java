package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.transport.TournamentShortTransport;

public class TournamentShortMapper {

    public static TournamentShortTransport toTournamentShortTransport(Tournament tournament) {
        return TournamentShortTransport.builder()
                .name(tournament.getEvent().getName())
                .category(tournament.getCategory().getName())
                .build();

    }
}
