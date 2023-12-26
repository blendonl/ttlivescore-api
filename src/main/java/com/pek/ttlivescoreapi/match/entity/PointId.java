package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.user.entity.User;

import java.io.Serializable;

public class PointId implements Serializable {
    private long id;
    private Match match;
    private User player;
    private Set set;
}
