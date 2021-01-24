package com.example.quinbay.quizbay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quinbay.quizbay.adapter.Quizbay_RecyclerView_HomeLeaderboard_Adapter;
import com.example.quinbay.quizbay.builder.Quizbay_Retrofit_Builer;
import com.example.quinbay.quizbay.models.Response3;
import com.example.quinbay.quizbay.networks.Quizbay_IApi_ProfileActivity2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class Quizbay_ProfileActivity2 extends AppCompatActivity {

    TextView textView;
    int total_score=0;

    ArrayList<Response3> mList = new ArrayList<Response3>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizbay_activity_profile2);
        Toast.makeText(Quizbay_ProfileActivity2.this,"button",Toast.LENGTH_LONG).show();
        textView= findViewById(R.id.tv_score);
        findViewById(R.id.bt_profile_leaderboard).setOnClickListener(View -> {

            Intent intent = new Intent(this,LeaderboardActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.bt_2).setOnClickListener(View -> {
            Intent intent = new Intent(this,Quizbay_Home_LeaderboardActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.bt_profile_pastquizes).setOnClickListener(View -> {
            Intent intent =new Intent(this,Quizbay_PastActivity.class);
            startActivity(intent);
        });




Toast.makeText(Quizbay_ProfileActivity2.this,"button",Toast.LENGTH_LONG).show();

        Retrofit retrofit = Quizbay_Retrofit_Builer.getInstance();
        Quizbay_IApi_ProfileActivity2 iMyAPIInterface = retrofit.create(Quizbay_IApi_ProfileActivity2.class);

        Call<List<Response3>> APICall =  iMyAPIInterface.getLeaderBoardByUserId("a9");
        APICall.enqueue(new Callback<List<Response3>>() {
            @Override
            public void onResponse(Call<List<Response3>> call, retrofit2.Response<List<Response3>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Quizbay_ProfileActivity2.this, "server returned data", Toast.LENGTH_SHORT).show();
                    // todo display the data instead of just a toast
                    for (Response3 response3 : response.body()) {

                        mList.add(response3);
                        total_score = total_score + (response3.getScore());

                    }
                    textView.setText(String.valueOf(total_score));

                    TextView textView2 = findViewById(R.id.tv_profilr_username);
                    textView2.setText(response.body().get(0).getUserName());
                    if(total_score>=50) {
                        ImageView imageView = findViewById(R.id.iv_profile_user_level);
                        imageView.setBackgroundResource(R.drawable.gold_level);
                        // imageView.setText("Gold");
                    }
                    else if(total_score>=25) {
                        ImageView imageView = findViewById(R.id.iv_profile_user_level);
                        imageView.setBackgroundResource(R.drawable.silver_level);
                    }
                    else if(total_score<25) {
                        ImageView imageView = findViewById(R.id.iv_profile_user_level);
                        imageView.setBackgroundResource(R.drawable.bronze_level);
                    }

                }
                else {
                    Toast.makeText(Quizbay_ProfileActivity2.this, "Server returned an error", Toast.LENGTH_SHORT).show();
                }
               // total_score = total_score + (response.body().get(i).getScore());
                //i++;
                //TextView textView = findViewById(R.id.tv_score);
                 //textView.setText(String.valueOf(response.body().get(0).getScore()));
                //TextView textView = findViewById(R.id.tv_leaderboard_winner_name);
                //String response1 = mList.get(0).getUserName();
                //textView.setText(response1);

               /*if(mList.size()>0)
               {
                   Toast.makeText(Quizbay_Home_LeaderboardActivity.this,"List is available",Toast.LENGTH_LONG).show();
               }*/
                Log.d("r", "onresponse");
                Toast.makeText(Quizbay_ProfileActivity2.this, String.valueOf(response.body().size()), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Response3>> call, Throwable t) {
                Toast.makeText(Quizbay_ProfileActivity2.this, "failed", Toast.LENGTH_SHORT).show();

                Log.d("result", t.getMessage());
            }

        });

        Toast.makeText(Quizbay_ProfileActivity2.this, String.valueOf(total_score), Toast.LENGTH_SHORT).show();

        //findViewById(R.id.bt_profile_ts).setOnClickListener(View -> {





        //});


        /*
        Call<List<Response3>> APICall =  iMyAPIInterface.getLeaderBoardByUserId(1);
        APICall.enqueue(new Callback<List<Response3>>() {
            @Override
            public void onResponse(Call<List<Response3>> call, Response<List<Response3>> response) {
                mList.addAll(response);
                for (Response3 response3 : response.body()) {
                    mList.add(response3);
                }
            }
                            @Override
                            public void onFailure(Call<Response3> call, Throwable t) {
                                Toast.makeText(Quizbay_ProfileActivity2.this, "failed", Toast.LENGTH_SHORT).show();
                            }
        });*/

       // Response quizbay_user_profile = new Response(1,"Rahul Yadav","a1",89);


        /*TextView textView2 = findViewById(R.id.tv_total_score);
        textView2.setBackgroundResource(R.color.orange);
        TextView textView3 = findViewById(R.id.tv_score);
        textView3.setBackgroundResource(R.color.orange);
        TextView textView4 = findViewById(R.id.tv_your_level);
        textView4.setBackgroundResource(R.color.orange);
*/
             /*   //Toast.makeText(Quizbay_ProfileActivity2.this, String.valueOf(response.body().size()), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Quizbay_User_Profile> call, Throwable t) {
                Toast.makeText(Quizbay_ProfileActivity2.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });*/




        //textView.setBackground(ContextCompat.getColor(Quizbay_ProfileActivity2.this,R.color.black));

       // textView.setTextColor(getResources().getColor(R.color.solid_red));
        //String img_bronze = "";
        //String img_silver ="fb.png";
        //String img_gold ="https://images.app.goo.gl/uKhzug2oRPEGWk6a6/50x50.jpg";
        //ImageView imageView = findViewById(R.id.iv_user_level);
        //Glide.with(this)
          //      .load("https://images.app.goo.gl/RbQGcjoQZQ3TGe329")
            //    .into(imageView);
    }
}