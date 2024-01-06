package com.pek.ttlivescoreapi.league;

import com.pek.ttlivescoreapi.team.Team;
import com.pek.ttlivescoreapi.user.entity.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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

    @Enumerated(EnumType.STRING)
    private Category category;

    private int year;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "team",
            joinColumns = {
                    @JoinColumn(name = "league_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id")
            }
    )
    private List<Team> teams;

    private boolean isActive;


}
