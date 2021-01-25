package com.example.myapplication.quinbay.quizbay.quizbay;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.quinbay.quizbay.R;
import com.example.myapplication.quinbay.quizbay.quizbay.model.LeaderBoard;
import com.example.myapplication.quinbay.quizbay.quizbay.model.UserScore;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class QuizBay_Question_Dynamic_Activity extends AppCompatActivity {

    private static SimpleExoPlayer player;
    private int score;
    UserScore userScore = new UserScore();
    private int diffLevel;
    private LeaderBoard leaderBoard;
    private String quizId;
    private int skipCount;
    private boolean status;
    private int correctAnswerCount;
    private double timetaken;
    private UserScore userScoreprev;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_bay__question);


    }


}
