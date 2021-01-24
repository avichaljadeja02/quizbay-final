package com.example.demoPostGres.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CompositeKey.class)
@Table(name = "userScores")
public class UserScores {
    @Id
    String userId;
    @Id
    int quizId;
    int numberOfQuestions;
    int score;
    int currentQuestionCount;
    int skippedQuestions;
    int correctCount;
    boolean quizStatus;
    double timeTaken;

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentQuestionCount() {
        return currentQuestionCount;
    }

    public void setCurrentQuestionCount(int currentQuestionCount) {
        this.currentQuestionCount = currentQuestionCount;
    }

    public int getSkippedQuestions() {
        return skippedQuestions;
    }

    public void setSkippedQuestions(int skippedQuestions) {
        this.skippedQuestions = skippedQuestions;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public boolean isQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(boolean quizStatus) {
        this.quizStatus = quizStatus;
    }
}
