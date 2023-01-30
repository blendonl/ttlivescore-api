package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private User player;

    @ManyToOne()
    private Match match;

}
