package com.example.demoPostGres.repository;

import com.example.demoPostGres.entity.Question;
import com.example.demoPostGres.entity.UserScores;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, Integer>{

}
