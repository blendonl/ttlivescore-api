package com.pek.ttlivescoreapi.entity;

import com.pek.ttlivescoreapi.user.User;
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
