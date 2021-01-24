package com.example.contestCreation.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quizMaster")
public class QuizMaster {
    @Id
    private String masterId;
    private String masterName;
    private List<Integer> quizId;
    private double masterRating;
    private int count;


    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }


    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public List<Integer> getQuizId() {
        return quizId;
    }

    public void setQuizId(List<Integer> quizId) {
        this.quizId = quizId;
    }

    public double getMasterRating() {
        return masterRating;
    }

    public void setMasterRating(double masterRating) {
        this.masterRating = masterRating;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
