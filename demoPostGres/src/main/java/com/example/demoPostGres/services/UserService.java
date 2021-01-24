package com.example.demoPostGres.services;

import com.example.demoPostGres.entity.Question;
import com.example.demoPostGres.entity.QuizDetails;
import com.example.demoPostGres.entity.UserDetails;
import com.example.demoPostGres.entity.UserScores;

public interface UserService {
    void addUser(UserDetails userDetails);
    void uploadToQuizDetails(QuizDetails quizDetails);
    Question startQuiz(String userId,int quizId);
    Question continueQuiz(UserScores userScores);
    void endQuiz(UserScores userScores);

}
