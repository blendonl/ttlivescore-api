package com.pek.ttlivescoreapi.match.entity;

import lombok.*;

import javax.persistence.*;
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
    private long id;

    @ManyToOne
    @Id
    private Match match;

    @OneToMany(mappedBy = "set")
    private List<Point> points;

    private boolean isFinished;
}
