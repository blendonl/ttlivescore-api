package com.pek.ttlivescoreapi.event.entity;


import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.league.League;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Week extends Event {

    @Id
    @GeneratedValue()
    private Long id;

    @ManyToOne()
    private League league;

}
