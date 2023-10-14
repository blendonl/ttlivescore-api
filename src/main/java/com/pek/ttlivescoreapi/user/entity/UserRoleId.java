package com.pek.ttlivescoreapi.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserRoleId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;
}
