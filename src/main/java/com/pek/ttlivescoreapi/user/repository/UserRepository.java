package com.pek.ttlivescoreapi.user.repository;

import com.pek.ttlivescoreapi.user.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "Select * from users inner join users_roles ur on users.id = ur.user_id inner join role r on ur.roles_id = r.id where r.name = :role", nativeQuery = true)
    List<User> findAllByRoleName(String role);

    Optional<User> findByEmail(String email);


    @Query(value = "select * from users inner join team_users tu on users.id = tu.users_id where tu.team_id = :teamId", nativeQuery = true)
    List<User> findAllByTeamId(long teamId);

    @Query(value = "select * from users inner join team_users tu on users.id = tu.users_id inner join team t on tu.team_id = t.id where t.name = :team", nativeQuery = true)
    List<User> findAllByTeamName(String team);
}
