package com.example.myapplication.quinbay.quizbay.quizbay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.ColorUtils;

import com.bumptech.glide.Glide;
import com.example.myapplication.quinbay.quizbay.R;

import com.example.myapplication.quinbay.quizbay.quizbay.model.Questions;
import com.example.myapplication.quinbay.quizbay.quizbay.model.UserScore;
import com.example.myapplication.quinbay.quizbay.quizbay.network.IQuizBayStatic;
import com.example.myapplication.quinbay.quizbay.quizbay.retrofitbuilder.RetrofitBuilder;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;
import com.google.gson.Gson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class QuizBay_Question_Activity extends AppCompatActivity {

    SimpleExoPlayer player;
    private PlayerView playerView;
    private TextView tv_question;
    private TextView tv_optionA;
    private TextView tv_optionB;
    private TextView tv_optionC;
    private TextView tv_optionD;
    private ImageView iv_questionImage;
    private CardView cv_OptionA;
    private CardView cv_OptionB;
    private CardView cv_OptionC;
    private CardView cv_OptionD;
    List<String> correctAnswer;
    private CardView cv_options;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bay__question);


        playerView = findViewById(R.id.include_static_question);;
        tv_question = findViewById(R.id.tv_quizbay_static_question);
        tv_optionA  = findViewById(R.id.tv_quizbay_static_optionA);
        tv_optionB  = findViewById(R.id.tv_quizbay_static_optionB);
        tv_optionC  = findViewById(R.id.tv_quizbay_static_optionC);
        tv_optionD  = findViewById(R.id.tv_quizbay_static_optionD);
        iv_questionImage =findViewById(R.id.iv_quizbay_static_image);
        cv_OptionA = findViewById(R.id.cv_quizbay_static_optionA);
        cv_OptionB = findViewById(R.id.cv_quizbay_static_optionB);
        cv_OptionC = findViewById(R.id.cv_quizbay_static_optionC);
        cv_OptionD = findViewById(R.id.cv_quizbay_static_optionD);
        cv_options = findViewById(R.id.cv_quizbay_static_buttons);
        setView();
//        initializePlayer();
       cv_OptionA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(correctAnswer.contains("A"))
               {
                   cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));
               }
               else
               {
                   cv_OptionA.setCardBackgroundColor(Color.rgb(255,0,0));
                   if(correctAnswer.contains("B"))
                   {
                       cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                   }
                   if(correctAnswer.contains("C"))
                   {
                       cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                   }
                   if(correctAnswer.contains("D"))
                   {
                       cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));

                   }


               }
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                        releasePlayer();
                       Intent intent = new Intent(QuizBay_Question_Activity.this,QuizBay_Question_Activity.class);
                       intent.putExtra("quizId","1");
                       startActivity(intent);
                   }
               }, 2000);
           }
       });

        cv_OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains("B"))
                {
                    cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                }
                else
                {
                    cv_OptionB.setCardBackgroundColor(Color.rgb(255,0,0));
                    if(correctAnswer.contains("A"))
                    {
                        cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    if(correctAnswer.contains("C"))
                    {
                        cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    if(correctAnswer.contains("D"))
                    {
                        cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));

                    }

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        releasePlayer();
                        Intent intent = new Intent(QuizBay_Question_Activity.this,QuizBay_Question_Activity.class);
                        intent.putExtra("quizId","1");
                        startActivity(intent);
                    }
                }, 2000);



            }
        });


        cv_OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains("C"))
                {
                    cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                }
                else
                {
                    cv_OptionC.setCardBackgroundColor(Color.rgb(255,0,0));
                    if(correctAnswer.contains("B"))
                    {
                        cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    if(correctAnswer.contains("A"))
                    {
                        cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    if(correctAnswer.contains("D"))
                    {
                        cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));

                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        releasePlayer();
                        Intent intent = new Intent(QuizBay_Question_Activity.this,QuizBay_Question_Activity.class);
                        intent.putExtra("quizId","1");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });

        cv_OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains("D"))
                {
                    cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));
                }
                else
                {
                    cv_OptionD.setCardBackgroundColor(Color.rgb(255,0,0));
                    if(correctAnswer.contains("B"))
                    {
                        cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    if(correctAnswer.contains("C"))
                    {
                        cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    if(correctAnswer.contains("A"))
                    {
                        cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));

                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        releasePlayer();
                        Intent intent = new Intent(QuizBay_Question_Activity.this,QuizBay_Question_Activity.class);
                        intent.putExtra("quizId","1");
                        startActivity(intent);
                    }
                }, 2000);
            }
        });


    }

//
    private void setView()
    {
        SharedPreferences  sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        Gson gson = new Gson();

        String quizId = getIntent().getStringExtra("quizId");
        //change QuizId to Variable
        String json = sharedPreferences.getString("quizId", "");
        UserScore userScoreprev = gson.fromJson(json, UserScore.class);

//        Log.d("APi", "setView: "+userScoreprev.toString());
//        UserScore userScore = new UserScore();
//        userScore.setScore(23);
//        userScore.setCurrentQuestionCount(0);
//        userScore.setQuizId(1);
//        userScore.setTimeTaken(325);
//        userScore.setSkippedQuestions(0);
//        userScore.setQuizStatus(0);
//        userScore.setUserId("1");
//        userScore.setNumberOfQuestions(10);
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IQuizBayStatic iQuizBayStatic = retrofit.create(IQuizBayStatic.class);

        Call<Questions> questionCall = iQuizBayStatic.getquestion(userScoreprev);
        Log.d("APi" , "Called");
        Callback<Questions> callback = new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {

                Log.d("APi", "onResponse: " + response.body().getQuestionName());
                Toast.makeText(QuizBay_Question_Activity.this, "hjsdffsdj", Toast.LENGTH_SHORT).show();

                Questions question = response.body();
                tv_optionA.setText(question.getOptionA());
                tv_optionB.setText(question.getOptionB());
                tv_optionC.setText(question.getOptionC());
                tv_optionD.setText(question.getOptionD());
                tv_question.setText(question.getQuestionName());
                correctAnswer = question.getOptions();
                if (question.getQuestionType().equals("text"))
                {
                    iv_questionImage.setVisibility(View.GONE);
                    playerView.setVisibility(View.GONE);
                }
                else if (question.getQuestionType().equals("image"))
                {

                    playerView.setVisibility(View.GONE);
                    Glide.with(QuizBay_Question_Activity.this)
                            .load(question.getQuestionSrc())
                            .placeholder(R.drawable.placeholder)
                            .into(iv_questionImage);

                }
                else if (question.getQuestionType().equals("mp3"))
                {

                    iv_questionImage.setVisibility(View.INVISIBLE);

                    initializePlayer(question.getQuestionSrc());
                }
                else
                {
                    iv_questionImage.setVisibility(View.INVISIBLE);
                    initializePlayer(question.getQuestionSrc());

                }



            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {
                Log.d("APi", "onFailure: " + t.getMessage());
                Toast.makeText(QuizBay_Question_Activity.this, "Crashes", Toast.LENGTH_SHORT).show();
            }
        };
        questionCall.enqueue(callback);















        userScoreprev.setCurrentQuestionCount(userScoreprev.getCurrentQuestionCount()+1);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String scoreJson = gson.toJson(userScoreprev);


        //change QuizId to Variable
        editor.putString("quizId", scoreJson);
        editor.commit();







    }





    private void initializePlayer(String src) {
        Log.d("APi", "initializePlayer: "+src);
                player = new SimpleExoPlayer.Builder(QuizBay_Question_Activity.this).build();
                playerView.setPlayer(player);
                MediaItem mediaItem = MediaItem.fromUri(src);
                player.setMediaItem(mediaItem);
                player.setPlayWhenReady(playWhenReady);

                player.seekTo(currentWindow, playbackPosition);
                player.prepare();

    }



    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        playerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }


    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }

    private void releasePlayer() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playbackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;
        }
    }


}