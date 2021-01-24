package com.example.quinbay.quizbay;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinbay.quizbay.adapter.Quizbay_RecyclerView_HomeLeaderboard_Adapter;
import com.example.quinbay.quizbay.adapter.Quizbay_RecyclerView_PastQuizes_Adapter;
import com.example.quinbay.quizbay.adapter.Quizbay_RecyclerView_PastQuizes_Quotes_Adapter;
import com.example.quinbay.quizbay.builder.Quizbay_Retrofit_Builer;
import com.example.quinbay.quizbay.models.Quizbay_PastQuizes;
import com.example.quinbay.quizbay.models.Response3;
import com.example.quinbay.quizbay.networks.Quizbay_IApi_ProfileActivity2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class Quizbay_PastActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    Quizbay_RecyclerView_PastQuizes_Adapter recyclerViewAdapter;
    Quizbay_RecyclerView_PastQuizes_Quotes_Adapter recyclerViewAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_quizes);

        recyclerView = findViewById(R.id.rv_quizbay_pastquizes);
        recyclerView1 = findViewById(R.id.rv_pastquizes_quotes);
        ArrayList<Response3> mList = new ArrayList<Response3>();

        Retrofit retrofit = Quizbay_Retrofit_Builer.getInstance();
        Quizbay_IApi_ProfileActivity2 iMyAPIInterface = retrofit.create(Quizbay_IApi_ProfileActivity2.class);

        Call<List<Response3>> APICall =  iMyAPIInterface.getLeaderBoardByUserId("a9");
        APICall.enqueue(new Callback<List<Response3>>() {
            @Override
            public void onResponse(Call<List<Response3>> call, retrofit2.Response<List<Response3>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Quizbay_PastActivity.this, "server returned data", Toast.LENGTH_SHORT).show();
                    // todo display the data instead of just a toast
                    for (Response3 response3 : response.body()) {
                        mList.add(response3);
                    }
                }
                else {
                    Toast.makeText(Quizbay_PastActivity.this, "Server returned an error", Toast.LENGTH_SHORT).show();
                }


                Log.d("r", "onresponse");
                Toast.makeText(Quizbay_PastActivity.this, String.valueOf(response.body().size()), Toast.LENGTH_SHORT).show();
                recyclerViewAdapter = new Quizbay_RecyclerView_PastQuizes_Adapter(mList, Quizbay_PastActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(Quizbay_PastActivity.this));
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Response3>> call, Throwable t) {
                Toast.makeText(Quizbay_PastActivity.this, "failed", Toast.LENGTH_SHORT).show();

                Log.d("result", t.getMessage());
            }

        });




        ArrayList<String> sList = new ArrayList<String>();
        String s1 = "The past can hurt. But the way I see it, you can either run from it, or learn from it.";
        String s2 = "The past is behind, learn from it.The future is ahead, prepare for it.The present is here, live it.";
        String s3 = "Those who cannot remember the past are condemned to repeat it.";
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);

        recyclerViewAdapter1 = new Quizbay_RecyclerView_PastQuizes_Quotes_Adapter(sList, Quizbay_PastActivity.this);
        recyclerView1.setLayoutManager(new LinearLayoutManager(Quizbay_PastActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setAdapter(recyclerViewAdapter1);

        //recyclerViewAdapter = new Quizbay_RecyclerView_PastQuizes_Adapter(mList, Quizbay_PastActivity.this);
        //recyclerView.setLayoutManager(new LinearLayoutManager(Quizbay_PastActivity.this));
        //recyclerView.setAdapter(recyclerViewAdapter);



    }



}
