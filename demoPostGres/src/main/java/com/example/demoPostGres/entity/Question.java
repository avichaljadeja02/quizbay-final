package com.example.demoPostGres.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Question")
public class Question {
    private int questionId;
    private String questionName;
    private List<String> options;
    private String answerType;
    private String questionType;
    private String questionSrc;
    private List<String> correctAnswer;
    private int count;
    private int difficultylevel;


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionSrc() {
        return questionSrc;
    }

    public void setQuestionSrc(String questionSrc) {
        this.questionSrc = questionSrc;
    }

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(List<String> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(int difficultylevel) {
        this.difficultylevel = difficultylevel;
    }
}
