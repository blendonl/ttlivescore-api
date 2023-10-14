package com.pek.ttlivescoreapi.user.entity;

import com.pek.ttlivescoreapi.team.Team;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name ="users")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true)
    private byte[] profilePicture;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;
    @OneToMany(mappedBy = "user")
    private List<UserRole> roles;

    @ManyToOne(fetch = FetchType.EAGER)
    private Team team;

}
