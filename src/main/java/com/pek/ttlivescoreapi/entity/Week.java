package com.pek.ttlivescoreapi.entity;


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
