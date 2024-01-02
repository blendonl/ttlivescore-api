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
    @Column(name = "event_id")
    private Long id;

    @ManyToOne()
    private League league;

    @OneToMany(mappedBy = "season")
    private List<Week> weeks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

}
