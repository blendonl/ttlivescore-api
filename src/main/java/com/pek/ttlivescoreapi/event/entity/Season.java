package com.pek.ttlivescoreapi.event.entity;

import com.pek.ttlivescoreapi.league.League;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    private League league;

    @OneToMany(mappedBy = "season")
    private List<Week> weeks;

    @OneToOne
    private Event event;

}
