package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.user.entity.User;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PointId.class)
@Builder
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Id
    private User player;

    @ManyToOne()
    @Id
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @Id
    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "set_id", referencedColumnName = "id"),
            @JoinColumn(name = "match_id", referencedColumnName = "match_id")
    })
    private Set set;

    private boolean isTeamA;


}
