package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchPlayerId implements Serializable {

    private Match match;

    private User player;
}
