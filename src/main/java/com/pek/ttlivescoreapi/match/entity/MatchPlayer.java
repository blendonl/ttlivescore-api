package com.pek.ttlivescoreapi.match.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pek.ttlivescoreapi.user.entity.User;
import jakarta.persistence.*;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.*;


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
