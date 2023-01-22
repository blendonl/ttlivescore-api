package com.pek.ttlivescoreapi.entity;

import lombok.*;

import javax.persistence.*;
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
    private Byte[] profilePicture;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private char gender;
    @OneToMany()
    private List<Role> roles;

}
