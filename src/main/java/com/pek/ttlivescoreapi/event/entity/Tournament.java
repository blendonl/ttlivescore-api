package com.pek.ttlivescoreapi.event.entity;

import com.pek.ttlivescoreapi.user.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tournament extends Event {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne()
    private Category category;

}