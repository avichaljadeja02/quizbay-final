package com.example.myapplication.quinbay.quizbay.quizbay.network;

import com.example.myapplication.quinbay.quizbay.quizbay.model.LeaderBoard;
import com.example.myapplication.quinbay.quizbay.quizbay.model.Questions;
import com.example.myapplication.quinbay.quizbay.quizbay.model.UserScore;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IQuizBayStatic {

    @POST("quizbay/user/continueQuiz")
    Call<Questions> getquestion(@Body  UserScore userScore);

    @POST("quizbay/user/endQuiz")
    Call<LeaderBoard> endquiz(@Body UserScore userScore);

    @POST("quizbay/leaderboard/upload")
    Call<Void> saveLeaderBoard(@Body LeaderBoard leaderBoard);
}
