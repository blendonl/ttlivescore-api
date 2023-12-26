package com.pek.ttlivescoreapi.match.repository;


import com.pek.ttlivescoreapi.match.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

}
