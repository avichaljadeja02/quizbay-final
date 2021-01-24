package com.example.quinbay.quizbay.models;

public class Quizbay_PastQuizes {
    private String quizName;

    public Quizbay_PastQuizes(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizName() {

        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
