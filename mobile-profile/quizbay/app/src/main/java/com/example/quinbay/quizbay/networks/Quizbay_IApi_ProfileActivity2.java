package com.example.quinbay.quizbay.networks;

import com.example.quinbay.quizbay.Response;
import com.example.quinbay.quizbay.models.Response3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Quizbay_IApi_ProfileActivity2 {

    @GET("user/{userId}")
    Call<List<Response3>> getLeaderBoardByUserId(@Path("userId") String userId);
}
