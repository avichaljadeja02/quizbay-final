package com.example.quinbay.quizbay;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinbay.quizbay.adapter.Quizbay_RecyclerView_HomeLeaderboard_Adapter;
import com.example.quinbay.quizbay.builder.Quizbay_Retrofit_Builer;
import com.example.quinbay.quizbay.networks.Quizbay_IApi_Home_Leaderboard;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Quizbay_Home_LeaderboardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Quizbay_RecyclerView_HomeLeaderboard_Adapter recyclerViewAdapter;

//Toast.(Quizbay_Home_LeaderboardActivity2.this , "button",Toast.LENGTH_LONG).show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizbay_activity_leaderboard);

        recyclerView = findViewById(R.id.rv_lb);



        ArrayList<com.example.quinbay.quizbay.Response> mList = new ArrayList<com.example.quinbay.quizbay.Response>();
       // com.example.quinbay.quizbay.Response quizbay_user_profile2 = new com.example.quinbay.quizbay.Response(1,"amit","9899",123);
        //mList.add(quizbay_user_profile2);
                Retrofit retrofit = Quizbay_Retrofit_Builer.getInstance();
        Quizbay_IApi_Home_Leaderboard iMyAPIInterface = retrofit.create(Quizbay_IApi_Home_Leaderboard.class);

        Call<List<com.example.quinbay.quizbay.Response>> APICall =  iMyAPIInterface.getOverallLeaderBoard();
        APICall.enqueue(new Callback<List<com.example.quinbay.quizbay.Response>>() {
            @Override
            public void onResponse(Call<List<com.example.quinbay.quizbay.Response>> call, Response<List<com.example.quinbay.quizbay.Response>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Quizbay_Home_LeaderboardActivity.this, "server returned data", Toast.LENGTH_SHORT).show();
                    // todo display the data instead of just a toast
                }
                else {
                    Toast.makeText(Quizbay_Home_LeaderboardActivity.this, "Server returned an error", Toast.LENGTH_SHORT).show();
                }
                for (com.example.quinbay.quizbay.Response quizbay_user_profile : response.body()) {
                    mList.add(quizbay_user_profile);
                }
                TextView textView = findViewById(R.id.tv_leaderboard_winner_name);
                String response1 = mList.get(0).getUserName();
                textView.setText(response1);

               /*if(mList.size()>0)
               {
                   Toast.makeText(Quizbay_Home_LeaderboardActivity.this,"List is available",Toast.LENGTH_LONG).show();
               }*/
                Log.d("r", "onresponse");
                Toast.makeText(Quizbay_Home_LeaderboardActivity.this, String.valueOf(response.body().size()), Toast.LENGTH_SHORT).show();
                recyclerViewAdapter = new Quizbay_RecyclerView_HomeLeaderboard_Adapter(mList, Quizbay_Home_LeaderboardActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(Quizbay_Home_LeaderboardActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<com.example.quinbay.quizbay.Response>> call, Throwable t) {
                Toast.makeText(Quizbay_Home_LeaderboardActivity.this, "failed", Toast.LENGTH_SHORT).show();

                Log.d("result", t.getMessage());
            }

        });





    }



}
