package com.pek.ttlivescoreapi.match.entity;


import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.team.Team;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class TeamMatch {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne()
    private Event event;

    @ManyToOne()
    private Team team1;

    @ManyToOne()
    private Team team2;

    @OneToMany()
    private List<Match> matches;

}
