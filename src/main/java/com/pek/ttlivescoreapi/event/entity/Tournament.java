package com.pek.ttlivescoreapi.event.entity;

import com.pek.ttlivescoreapi.user.entity.Category;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne()
    private Event event;

    @ManyToOne()
    private Category category;

}
