package com.pek.ttlivescoreapi.league;

import com.pek.ttlivescoreapi.team.entity.TeamLeague;
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

    @OneToMany(mappedBy = "league")
    private List<TeamLeague> teams;

    private boolean isActive;


}
