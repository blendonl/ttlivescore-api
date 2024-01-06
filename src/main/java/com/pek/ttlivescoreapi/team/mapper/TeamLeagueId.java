package com.pek.ttlivescoreapi.team.mapper;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TeamLeagueId implements Serializable {

    @Column(name = "team_id")
    private int teamId;

    @Column(name = "league_id")
    private int leagueId;

}
