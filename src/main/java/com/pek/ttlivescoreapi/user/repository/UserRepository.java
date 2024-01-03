package com.pek.ttlivescoreapi.user.repository;

import com.pek.ttlivescoreapi.user.entity.Role;
import com.pek.ttlivescoreapi.user.entity.User;
import com.pek.ttlivescoreapi.user.transport.UserQueryTransport;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users where users.name = :#{#query.firstName} or users.last_name = :#{#query.lastName} or users.email = :#{#query.email}", nativeQuery = true)
    List<User> findAllWithQuery(@Param("query") UserQueryTransport query);

    List<User> findAllByRolesContaining(Role role);

    Optional<User> findByEmail(String email);


    @Query(value = "select * from users u inner join users_teams ut on u.id = ut.user_id where ut.team_id = :teamId", nativeQuery = true)
    List<User> findAllByTeamId(long teamId);

    @Query(value = "select u.id, birth_date, email, gender, last_name, u.name, password, profile_picture, team_id, t.name, league_id from users u left join users_teams ut on u.id = ut.user_id left join team t on t.id = ut.team_id where t.name = :team", nativeQuery = true)
    List<User> findAllByTeamName(String team);

    @Query(value = "select case when count(*) = 1 then 'TRUE' else 'FALSE' end from users where users.email = :email", nativeQuery = true)
    boolean existsByEmail(String email);

    @Query(value = "delete from users where users.email = :email", nativeQuery = true)
    void deleteByEmail(String email);
}
