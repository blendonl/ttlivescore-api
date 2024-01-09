package com.pek.ttlivescoreapi.user.entity;

import com.pek.ttlivescoreapi.match.entity.Point;
import com.pek.ttlivescoreapi.team.Team;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] profilePicture;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "users_teams", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")})
    private List<Team> teams = new ArrayList<>();

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<Point> points = new ArrayList<>();


}