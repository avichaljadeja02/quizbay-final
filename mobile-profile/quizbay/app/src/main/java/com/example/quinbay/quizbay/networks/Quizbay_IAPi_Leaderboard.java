package com.example.quinbay.quizbay.networks;

import com.example.quinbay.quizbay.models.Quizbay_Leaderboard_Class;
import com.example.quinbay.quizbay.models.Response2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Quizbay_IAPi_Leaderboard {

    @GET("quiz/{quizId}")
    Call<List<Response2>> getLeaderBoardByQuizId(@Path("quizId") int quizId);
}
