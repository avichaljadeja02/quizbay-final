package com.example.myapplication.quinbay.quizbay.quizbay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.quinbay.quizbay.R;
import com.example.myapplication.quinbay.quizbay.quizbay.model.UserScore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserScore userScore = new UserScore();
                userScore.setCorrectCount(0);
                userScore.setCurrentQuestionCount(0);
                userScore.setNumberOfQuestions(5);
                userScore.setQuizId(1);
                userScore.setUserId("2");
                userScore.setQuizStatus(0);
                userScore.setSkippedQuestions(0);
                userScore.setTimeTaken(234);
                userScore.setScore(0);
                SharedPreferences  sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String scoreJson = gson.toJson(userScore);
                //change QuizId to Variable
                editor.putString("quizId", scoreJson);
                editor.commit();
                Intent intent = new Intent(MainActivity.this,QuizBay_Question_Activity.class);
                intent.putExtra("quizId","1");
                startActivity(intent);
                finish();

            }
        });
    }

//    FirebaseMessaging.getInstance().getToken()
//    .addOnCompleteListener(new OnCompleteListener<String>() {
//        @Override
//        public void onComplete(@NonNull Task<String> task) {
//            if (!task.isSuccessful()) {
//                Log.w(TAG, "Fetching FCM registration token failed", task.getException());
//                return;
//            }
//
//            // Get new FCM registration token
//            String token = task.getResult();
//
//            // Log and toast
//            String msg = getString(R.string.msg_token_fmt, token);
//            Log.d(TAG, msg);
//            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//        }
//    }


}