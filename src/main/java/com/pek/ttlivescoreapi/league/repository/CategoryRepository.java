package com.pek.ttlivescoreapi.league.repository;

import com.pek.ttlivescoreapi.user.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


    Optional<Category> findByName(String name);

    boolean existsByName(String name);
}
