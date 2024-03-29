package com.pek.ttlivescoreapi.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pek.ttlivescoreapi.league.League;
import com.pek.ttlivescoreapi.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToOne()
    private League league;

    @ManyToMany(mappedBy = "teams", cascade = {CascadeType.MERGE})
    private List<User> users;

}