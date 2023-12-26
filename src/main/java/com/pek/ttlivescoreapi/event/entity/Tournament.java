package com.pek.ttlivescoreapi.event.entity;

import com.pek.ttlivescoreapi.user.entity.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


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
