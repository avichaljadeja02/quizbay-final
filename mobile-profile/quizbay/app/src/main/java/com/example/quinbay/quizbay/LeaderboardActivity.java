package com.example.quinbay.quizbay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quinbay.quizbay.adapter.Quizbay_RecyclerView_Leaderboard_Adapter;
import com.example.quinbay.quizbay.builder.Quizbay_Retrofit_Builer;
import com.example.quinbay.quizbay.models.Quizbay_Leaderboard_Class;
import com.example.quinbay.quizbay.models.Response2;
import com.example.quinbay.quizbay.networks.Quizbay_IAPi_Leaderboard;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LeaderboardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Quizbay_RecyclerView_Leaderboard_Adapter recyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizbay_activity_leaderboard);

        recyclerView = findViewById(R.id.rv_lb);

      //  Quizbay_Leaderboard_Class quizbay_leaderboard_class = new Quizbay_Leaderboard_Class(1,"amit",9899,"quiz1",1);
        //Quizbay_Leaderboard_Class quizbay_leaderboard_class2 = new Quizbay_Leaderboard_Class(2,"rahul",78,"quiz2",2);
       // Quizbay_Leaderboard_Class quizbay_leaderboard_class3 = new Quizbay_Leaderboard_Class(3,"surya",34,"quiz3",3);
        ArrayList<Response2> mList = new ArrayList<Response2>();
       // mList.add(quizbay_leaderboard_class);
        //mList.add(quizbay_leaderboard_class2);
        //mList.add(quizbay_leaderboard_class3);
        findViewById(R.id.iv_trophy).setOnClickListener(View -> {

                Toast.makeText(LeaderboardActivity.this,"List is available",Toast.LENGTH_LONG).show();
        });

       // recyclerViewAdapter = new Quizbay_RecyclerView_Leaderboard_Adapter(mList, LeaderboardActivity.this);
       // recyclerView.setLayoutManager(new LinearLayoutManager(LeaderboardActivity.this,LinearLayoutManager.VERTICAL, false));
       // recyclerView.setAdapter(recyclerViewAdapter);


        Retrofit retrofit = Quizbay_Retrofit_Builer.getInstance();
        Quizbay_IAPi_Leaderboard iMyAPIInterface = retrofit.create(Quizbay_IAPi_Leaderboard.class);

        Call<List<Response2>> APICall =  iMyAPIInterface.getLeaderBoardByQuizId(2);
        APICall.enqueue(new Callback<List<Response2>>() {
            @Override
            public void onResponse(Call<List<Response2>> call, Response<List<Response2>> response) {
                for (Response2 quizbay_leaderboard_class : response.body()) {
                    mList.add(quizbay_leaderboard_class);
                }

                Toast.makeText(LeaderboardActivity.this, String.valueOf(response.body().size()), Toast.LENGTH_SHORT).show();
                recyclerViewAdapter = new Quizbay_RecyclerView_Leaderboard_Adapter(mList, LeaderboardActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(LeaderboardActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Response2>> call, Throwable t) {
                Toast.makeText(LeaderboardActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });



    }


}