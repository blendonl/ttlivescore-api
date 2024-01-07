package com.pek.ttlivescoreapi.team.entity;

import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.team.mapper.TeamLeagueId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeamLeague {

    @EmbeddedId
    private TeamLeagueId id;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    @MapsId("teamId")
    private Team team;
    @ManyToOne()
    @JoinColumn(name = "league_id")
    @MapsId("leagueId")
    private League league;

    private int year;
}
