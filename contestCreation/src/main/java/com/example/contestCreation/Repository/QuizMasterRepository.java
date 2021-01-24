package com.example.contestCreation.Repository;

import com.example.contestCreation.Model.QuizMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizMasterRepository extends MongoRepository<QuizMaster,String> {
    QuizMaster findByMasterId(String id);
}
