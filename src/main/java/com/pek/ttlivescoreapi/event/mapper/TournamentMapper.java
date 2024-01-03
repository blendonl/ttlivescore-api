package com.pek.ttlivescoreapi.event.mapper;

import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.transport.TournamentTransport;

public class TournamentMapper {

    public static TournamentTransport toTournamentTransport(Tournament tournament) {
        return TournamentTransport.builder()
                .id(tournament.getId())
                .date(tournament.getEvent().getDate())
                .category(tournament.getCategory().getName())
                .name(tournament.getEvent().getName())
                .build();
    }
}
