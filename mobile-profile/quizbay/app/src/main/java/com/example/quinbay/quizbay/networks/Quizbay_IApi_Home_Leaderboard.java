package com.example.quinbay.quizbay.networks;

import com.example.quinbay.quizbay.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Quizbay_IApi_Home_Leaderboard {
    @GET("overallleaderboard")
    Call<List<Response>> getOverallLeaderBoard();
}