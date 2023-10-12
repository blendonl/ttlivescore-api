package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.event.entity.Event;
import com.pek.ttlivescoreapi.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {

    public Match(long id) {
        this.id = id;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private boolean finished;

    @ManyToOne()
    private User referee;

    @ManyToOne()
    private Event event;

    @OneToMany(mappedBy = "match")
    private List<MatchPlayer> matchPlayers;


}
