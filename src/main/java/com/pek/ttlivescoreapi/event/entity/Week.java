package com.pek.ttlivescoreapi.event.entity;


import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.league.League;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter
@Setter
public class Week {
    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private Date date;
    @ManyToOne()
    private Season season;

}
