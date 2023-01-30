package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private boolean finished;

    @ManyToOne()
    private User referee;

    @ManyToOne()
    private Event event;


}
