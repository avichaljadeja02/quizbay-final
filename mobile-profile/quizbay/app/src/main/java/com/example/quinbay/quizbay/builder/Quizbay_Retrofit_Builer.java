package com.example.quinbay.quizbay.builder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Quizbay_Retrofit_Builer {

    private static Retrofit instance;

    private Quizbay_Retrofit_Builer() {
        //private constructor
    }

    public static Retrofit getInstance() {
        if(instance == null) {
            synchronized (Quizbay_Retrofit_Builer.class) {
                if(instance == null) {
                    instance = new Retrofit.Builder()
                            .baseUrl("http://10.177.1.183:8082/quizbay/leaderboard/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient())
                            .build();
                }
            }
        }
        return instance;
    }


}
