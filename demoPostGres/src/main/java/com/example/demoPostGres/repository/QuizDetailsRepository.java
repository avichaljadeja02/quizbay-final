package com.example.demoPostGres.repository;

import com.example.demoPostGres.entity.QuizDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDetailsRepository extends MongoRepository<QuizDetails,Integer> {
    QuizDetails getByQuizId(int quizId);
}
