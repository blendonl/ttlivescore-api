package com.pek.ttlivescoreapi.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
