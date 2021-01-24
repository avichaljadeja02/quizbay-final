package com.example.contestCreation.Services.impl;

import com.example.contestCreation.Model.Questions;
import com.example.contestCreation.Model.QuizDetails;
import com.example.contestCreation.Model.QuizMaster;
import com.example.contestCreation.Repository.QuizDetailsRepository;
import com.example.contestCreation.Repository.QuizMasterRepository;
import com.example.contestCreation.Services.ContestCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContestCreationServiceImpl implements ContestCreationService {

    @Autowired
    QuizDetailsRepository quizDetailsRepository;

    @Autowired
    QuizMasterRepository quizMasterRepository;

    @Override
    public void saveQuiz(QuizDetails quizDetails){
        quizDetails.setQuizId((int)quizDetailsRepository.count()+1);
        quizDetailsRepository.insert(quizDetails);
        QuizMaster quizMaster = quizMasterRepository.findByMasterId(quizDetails.getMasterId());
        List<Integer> quizMasterRow;
        quizMasterRow = quizMaster.getQuizId();
        quizMasterRow.add(quizDetails.getQuizId());
        quizMaster.setQuizId(quizMasterRow);
        quizMasterRepository.save(quizMaster);
    }

    @Override
    public void addMaster(QuizMaster quizMaster){
        quizMaster.setCount(0);
        quizMaster.setMasterRating(2.5);
        quizMasterRepository.insert(quizMaster);
    }

    @Override
    public List<QuizDetails> getQuizDetails(String masterId){
        List<QuizDetails> quizDetailsList = quizDetailsRepository.findByMasterId(masterId);
        return quizDetailsList;
    }

    @Override
    public QuizDetails getSingleQuizDetails(String masterId,int quizId){
        return quizDetailsRepository.findByQuizIdAndMasterId(quizId,masterId);
    }

    @Override
    public double getRating(String masterId){
        return quizMasterRepository.findByMasterId(masterId).getMasterRating();
    }

    @Override
    public void updateMasterRating(String masterId,double rating){
        QuizMaster quizMaster = quizMasterRepository.findByMasterId(masterId);
        double ratingVal = quizMaster.getMasterRating()*quizMaster.getCount()+rating;
        ratingVal = (ratingVal/(quizMaster.getCount()+1));
        quizMaster.setMasterRating(ratingVal);
        quizMaster.setCount(quizMaster.getCount()+1);
        quizMasterRepository.save(quizMaster);
    }

    @Override
    public List<QuizDetails> getActiveQuizzes(String category) {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<QuizDetails> activeQuizDetailsList = new ArrayList<>();
        List<QuizDetails> quizDetailsList = quizDetailsRepository.findByCategory(category);
        for (QuizDetails quizDetails : quizDetailsList) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String start = quizDetails.getStartTime();
            String end = quizDetails.getEndTime();
            LocalDateTime startTime = LocalDateTime.parse(start, formatter);
            LocalDateTime endTime = LocalDateTime.parse(end, formatter);
            if(startTime.isBefore(localDateTime) && endTime.isAfter(localDateTime)){
                activeQuizDetailsList.add(quizDetails);
            }
        }
        return activeQuizDetailsList;
    }

    @Override
    public List<QuizDetails> getActiveQuizzesByMaster(String masterId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<QuizDetails> activeQuizDetailsList = new ArrayList<>();
        List<QuizDetails> quizDetailsList = quizDetailsRepository.findByMasterId(masterId);
        for (QuizDetails quizDetails : quizDetailsList) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String start = quizDetails.getStartTime();
            String end = quizDetails.getEndTime();
            LocalDateTime startTime = LocalDateTime.parse(start, formatter);
            LocalDateTime endTime = LocalDateTime.parse(end, formatter);
            if(startTime.isBefore(localDateTime) && endTime.isAfter(localDateTime)){
                activeQuizDetailsList.add(quizDetails);
            }
        }
        return activeQuizDetailsList;
    }

    @Override
    public List<QuizDetails> getPastQuizzesByMaster(String masterId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<QuizDetails> activeQuizDetailsList = new ArrayList<>();
        List<QuizDetails> quizDetailsList = quizDetailsRepository.findByMasterId(masterId);
        for (QuizDetails quizDetails : quizDetailsList) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String end = quizDetails.getEndTime();
            LocalDateTime endTime = LocalDateTime.parse(end, formatter);
            if(endTime.isBefore(localDateTime)){
                activeQuizDetailsList.add(quizDetails);
            }
        }
        return activeQuizDetailsList;
    }


    @Override
    public List<QuizDetails> getFutureQuizzesByMaster(String masterId) {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<QuizDetails> activeQuizDetailsList = new ArrayList<>();
        List<QuizDetails> quizDetailsList = quizDetailsRepository.findByMasterId(masterId);
        for (QuizDetails quizDetails : quizDetailsList) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String start = quizDetails.getStartTime();
            LocalDateTime startTime = LocalDateTime.parse(start, formatter);
            if(startTime.isAfter(localDateTime)){
                activeQuizDetailsList.add(quizDetails);
            }
        }
        return activeQuizDetailsList;
    }

    @Override
    public List<QuizDetails> getDynamicQuizzes(String masterId) {
        return quizDetailsRepository.findByMasterIdAndQuizType(masterId,true);
    }

    @Override
    public List<QuizDetails> getByCategory(String category){
        return quizDetailsRepository.findByCategory(category);
    }

    @Override
    public Questions getByQue(int quizId, int quesId){
        QuizDetails questions = quizDetailsRepository.findByQuizId(quizId);
        List<Questions> questionsList = questions.getQuestions();
        return questionsList.get(quesId);
    }
}
