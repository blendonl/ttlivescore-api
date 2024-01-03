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
    @Column(name = "event_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "event_id")
    private Event event;

    @ManyToOne()
    private Category category;

}
