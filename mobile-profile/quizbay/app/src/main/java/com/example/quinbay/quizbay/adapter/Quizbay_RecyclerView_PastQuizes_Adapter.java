package com.example.quinbay.quizbay.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinbay.quizbay.R;
import com.example.quinbay.quizbay.models.Quizbay_PastQuizes;
import com.example.quinbay.quizbay.models.Response2;
import com.example.quinbay.quizbay.models.Response3;

import java.util.ArrayList;

public class Quizbay_RecyclerView_PastQuizes_Adapter extends RecyclerView.Adapter<Quizbay_RecyclerView_PastQuizes_Adapter.PostHolder> {

    private ArrayList<Response3> mList;
    private Context mContext;

    public Quizbay_RecyclerView_PastQuizes_Adapter(ArrayList<Response3> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public Quizbay_RecyclerView_PastQuizes_Adapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_quizbay_pastquizes, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Quizbay_RecyclerView_PastQuizes_Adapter.PostHolder holder, int position) {


        //get user postion
        Response3 response3 = mList.get(position);

        //set id
//        holder.tv_quiz_rank.setText(position+1);
        holder.tv_quiz.setText(response3.getQuizName());
        holder.tv_quiz_score.setText(String.valueOf(response3.getScore()));
        }


    @Override
    public int getItemCount() {
        return (mList == null) ? 0 : mList.size();
    }

    //class PostHolder extends RecyclerView.ViewHolder {


    //}




    public class PostHolder extends RecyclerView.ViewHolder{
        private final TextView tv_quiz;
        private final TextView tv_quiz_score;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            tv_quiz = itemView.findViewById(R.id.tv_pastquizes_quizname);
            tv_quiz_score = itemView.findViewById(R.id.tv_pastquizes_score);
        }
    }
}


