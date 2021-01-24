package com.example.quinbay.quizbay.models;

public class Quizbay_Leaderboard_Class {

    private int user_id;
    private String user_name;
    private int total_score;
    private String quiz_name;
    private int quiz_id;

    public Quizbay_Leaderboard_Class(int user_id, String user_name, int total_score, String quiz_name, int quiz_id) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.total_score = total_score;
        this.quiz_name = quiz_name;
        this.quiz_id = quiz_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public String getQuiz_name() {
        return quiz_name;
    }

    public void setQuiz_name(String quiz_name) {
        this.quiz_name = quiz_name;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }
}
