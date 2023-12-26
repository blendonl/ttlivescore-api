package com.pek.ttlivescoreapi.match.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(SetId.class)
public class Set {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @Id
    @JoinColumn(nullable = false)
    private Match match;

    @OneToMany(mappedBy = "set")
    private List<Point> points;

    private boolean isFinished;
}
