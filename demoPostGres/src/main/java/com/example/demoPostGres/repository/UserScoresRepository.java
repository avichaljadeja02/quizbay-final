package com.example.demoPostGres.repository;

import com.example.demoPostGres.entity.Question;
import com.example.demoPostGres.entity.UserScores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoresRepository extends CrudRepository<UserScores, Integer> {

}
