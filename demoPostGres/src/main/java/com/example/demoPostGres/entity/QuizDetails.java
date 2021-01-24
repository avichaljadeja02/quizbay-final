package com.example.demoPostGres.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection ="QuizDetails")
public class QuizDetails {
    @Id
    private int quizId;
    private String masterId;
    private int noOfQuestions;
    private String quizName;
    private Boolean quizType;
    private String startTime;
    private String endTime;
    private String category;
    private List<Question> questions;
    private int mostAnsweredQuestion;

    public Boolean getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(Boolean quizStatus) {
        this.quizStatus = quizStatus;
    }

    private Boolean quizStatus;

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Boolean getQuizType() {
        return quizType;
    }

    public void setQuizType(Boolean quizType) {
        this.quizType = quizType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getMostAnsweredQuestion() {
        return mostAnsweredQuestion;
    }

    public void setMostAnsweredQuestion(int mostAnsweredQuestion) {
        this.mostAnsweredQuestion = mostAnsweredQuestion;
    }
}
