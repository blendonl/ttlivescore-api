package com.pek.ttlivescoreapi.match.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pek.ttlivescoreapi.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(MatchPlayerId.class)
public class MatchPlayer {
    @ManyToOne
    @Id
    private User player;

    @ManyToOne()
    @Id
    @JsonIgnore
    private Match match;

    private boolean side;
    private boolean doubles;
}
