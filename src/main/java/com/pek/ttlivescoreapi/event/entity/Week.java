package com.pek.ttlivescoreapi.event.entity;


import com.pek.ttlivescoreapi.league.League;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Week {
    @Id
    @Column(name = "event_id")
    private Long id;

    private SeasonType season;

    @ManyToOne
    private League league;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

}
