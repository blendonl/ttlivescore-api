package com.pek.ttlivescoreapi.league.repository;

import com.pek.ttlivescoreapi.user.entity.Category;

import java.util.Optional;

//@Repository
public interface CategoryRepository {


    Optional<Category> findByName(String name);

    boolean existsByName(String name);
}
