package com.example.demoPostGres.services.impl;

import com.example.demoPostGres.entity.Question;
import com.example.demoPostGres.entity.QuizDetails;
import com.example.demoPostGres.entity.UserDetails;
import com.example.demoPostGres.entity.UserScores;
import com.example.demoPostGres.repository.QuizDetailsRepository;
import com.example.demoPostGres.repository.UserDetailsRepository;
import com.example.demoPostGres.repository.UserScoresRepository;
import com.example.demoPostGres.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    QuizDetailsRepository quizDetailsRepository;

    @Autowired
    UserScoresRepository userScoresRepository;

    @Override
    public void addUser(UserDetails userDetails){
        userDetails.setListQuizIds(new ArrayList<>());
        userDetailsRepository.insert(userDetails);
    }
    @Override
    public void uploadToQuizDetails(QuizDetails quizDetails) {
        quizDetailsRepository.insert(quizDetails);
    }

    @Override
    public Question startQuiz(String userId,int quizId){
        QuizDetails quizDetails = quizDetailsRepository.getByQuizId(quizId);
        UserDetails userDetails = userDetailsRepository.getById(userId);
        List<Integer> listOfIds = userDetails.getListQuizIds();
        listOfIds.add(quizId);
        userDetails.setListQuizIds(listOfIds);
        userDetailsRepository.save(userDetails);
        UserScores userScores = new UserScores();
        userScores.setUserId(userId);
        userScores.setQuizId(quizId);
        userScores.setNumberOfQuestions(0);
        userScores.setScore(0);
        userScores.setCurrentQuestionCount(0);
        userScores.setSkippedQuestions(0);
        userScores.setCorrectCount(0);
        userScores.setQuizStatus(false);
        userScores.setTimeTaken(0);
        userScoresRepository.save(userScores);
        return quizDetails.getQuestions().get(0);
    }

    @Override
    public Question continueQuiz(UserScores userScores){
        userScoresRepository.save(userScores);
        int questionId = userScores.getCurrentQuestionCount();
        int quizId = userScores.getQuizId();
        QuizDetails quizDetails = quizDetailsRepository.getByQuizId(quizId);
        return quizDetails.getQuestions().get(questionId);
    }

    @Override
    public void endQuiz(UserScores userScores){
        userScoresRepository.save(userScores);
    }


}
