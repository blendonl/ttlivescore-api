package com.pek.ttlivescoreapi.match.entity;

import com.pek.ttlivescoreapi.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "player1_id", referencedColumnName = "id", nullable = false)
    private User player1;

    @ManyToOne( )
    @JoinColumn(name = "player2_id", referencedColumnName = "id")
    private User player2;

    @ManyToOne()
    private Match match;

}
