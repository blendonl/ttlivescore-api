package com.pek.ttlivescoreapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class SingleMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private boolean finished;
    @ManyToOne()
    private User player1;
    @ManyToOne()
    private User player2;

    @ManyToOne()
    private User referee;

    @ManyToOne()
    private Event event;

}
