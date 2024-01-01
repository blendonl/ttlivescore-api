package com.pek.ttlivescoreapi.event.mapper;


import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.event.entity.Tournament;
import com.pek.ttlivescoreapi.event.transport.TournamentCreateTransport;
import com.pek.ttlivescoreapi.user.entity.Category;

public class TournamentCreateMapper {

    public static Tournament toTournament(TournamentCreateTransport tournament) {
        return Tournament.builder()
                .event(Event.builder().name(tournament.getName()).build())
                .category(Category.builder().name(tournament.getCategory()).build())
                .build();


    }
}
