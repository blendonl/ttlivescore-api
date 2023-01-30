package com.pek.ttlivescoreapi.league;

import com.pek.ttlivescoreapi.user.entity.Category;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "league")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToOne()
    private Category category;

    private int year;


}
