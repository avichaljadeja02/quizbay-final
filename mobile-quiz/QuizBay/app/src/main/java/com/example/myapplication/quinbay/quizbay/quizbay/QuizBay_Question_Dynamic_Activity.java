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
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.List;

public class QuizBay_Question_Dynamic_Activity extends AppCompatActivity {

    private SimpleExoPlayer player;
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
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








        cv_OptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains(tv_optionA.getText().toString()))
                {
                    cv_OptionA.setCardBackgroundColor(Color.rgb(255,0,0));
                }
                else
                {
                    cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));
                    if(correctAnswer.contains(tv_optionB.getText().toString()))
                    {
                        cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else if(correctAnswer.contains(tv_optionC.getText().toString()))
                    {
                        cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else
                    {
                        cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));

                    }


                }
            }
        });

        cv_OptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains(tv_optionB.getText().toString()))
                {
                    cv_OptionB.setCardBackgroundColor(Color.rgb(255,0,0));
                }
                else
                {
                    cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                    if(correctAnswer.contains(tv_optionA.getText().toString()))
                    {
                        cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else if(correctAnswer.contains(tv_optionC.getText().toString()))
                    {
                        cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else
                    {
                        cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));

                    }

                }
            }
        });


        cv_OptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains(tv_optionC.getText().toString()))
                {
                    cv_OptionC.setCardBackgroundColor(Color.rgb(255,0,0));
                }
                else
                {
                    cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                    if(correctAnswer.contains(tv_optionB.getText().toString()))
                    {
                        cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else if(correctAnswer.contains(tv_optionA.getText().toString()))
                    {
                        cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else
                    {
                        cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));

                    }
                }
            }
        });

        cv_OptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correctAnswer.contains(tv_optionD.getText().toString()))
                {
                    cv_OptionD.setCardBackgroundColor(Color.rgb(255,0,0));
                }
                else
                {
                    cv_OptionD.setCardBackgroundColor(Color.rgb(0,255,0));
                    if(correctAnswer.contains(tv_optionB.getText().toString()))
                    {
                        cv_OptionB.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else if(correctAnswer.contains(tv_optionC.getText().toString()))
                    {
                        cv_OptionC.setCardBackgroundColor(Color.rgb(0,255,0));
                    }
                    else
                    {
                        cv_OptionA.setCardBackgroundColor(Color.rgb(0,255,0));

                    }
                }
            }
        });

    }
}
