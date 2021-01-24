package com.example.contestCreation.Services;

import com.example.contestCreation.Model.Questions;
import com.example.contestCreation.Model.QuizDetails;
import com.example.contestCreation.Model.QuizMaster;

import java.util.List;

public interface ContestCreationService {
    void saveQuiz(QuizDetails quizDetails);
    void addMaster(QuizMaster quizMaster);
    List<QuizDetails> getQuizDetails(String masterId);
    QuizDetails getSingleQuizDetails(String masterId,int quizId);
    double getRating(String masterId);
    void updateMasterRating(String masterId,double rating);
    List<QuizDetails> getActiveQuizzes(String category);
    List<QuizDetails> getPastQuizzesByMaster(String masterId);
    List<QuizDetails> getFutureQuizzesByMaster(String masterId);
    List<QuizDetails> getActiveQuizzesByMaster(String masterId);
    List<QuizDetails> getDynamicQuizzes(String masterId);
    List<QuizDetails> getByCategory(String category);
    Questions getByQue(int quizId, int quesId);
}
