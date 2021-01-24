package com.example.contestCreation.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quizDetails")
public class QuizDetails {
    @Id
    private int quizId;
    private String masterId;
    private int noOfQuestions;
    private String quizName;
    private String startTime;
    private String endTime;
    private Boolean quizType;
    private String category;
    private List<Questions> questions;
    private int mostAnsweredQuestionId;
    private int quizStatus;

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

    public Boolean getQuizType() {
        return quizType;
    }

    public void setQuizType(Boolean quizType) {
        this.quizType = quizType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public int getMostAnsweredQuestionId() {
        return mostAnsweredQuestionId;
    }

    public void setMostAnsweredQuestionId(int mostAnsweredQuestionId) {
        this.mostAnsweredQuestionId = mostAnsweredQuestionId;
    }

    public int getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(int quizStatus) {
        this.quizStatus = quizStatus;
    }
}
