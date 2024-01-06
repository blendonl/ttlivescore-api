package com.pek.ttlivescoreapi.team;

import com.pek.ttlivescoreapi.team.entity.TeamLeague;
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

    @OneToMany(mappedBy = "team", cascade = {CascadeType.MERGE})
    private List<TeamLeague> leagues;

    @ManyToMany(mappedBy = "teams", cascade = {CascadeType.MERGE})
    private List<User> users;

}