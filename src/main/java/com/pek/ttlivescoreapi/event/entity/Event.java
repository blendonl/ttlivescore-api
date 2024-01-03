package com.pek.ttlivescoreapi.event.entity;

import com.pek.ttlivescoreapi.match.entity.Match;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private EventType eventType;

    private String name;

    private Date date;

    private char gender;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "event")
    private Tournament tournament;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "event")
    private Week week;

    @OneToMany(mappedBy = "event")
    private List<Match> matches;

}
