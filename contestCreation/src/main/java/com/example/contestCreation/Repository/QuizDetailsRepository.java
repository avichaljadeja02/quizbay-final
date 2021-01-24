package com.example.contestCreation.Repository;

import com.example.contestCreation.Model.QuizDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizDetailsRepository extends MongoRepository<QuizDetails,Integer> {
    long count();
    List<QuizDetails> findByMasterId(String id);
    QuizDetails findByQuizIdAndMasterId(int quizId,String masterId);
    List<QuizDetails> findByMasterIdAndQuizType(String masterId,Boolean quizType);
    List<QuizDetails> findByCategory(String category);
    QuizDetails findByQuizId(int quizId);
}
