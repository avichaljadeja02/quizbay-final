package com.example.quinbay.quizbay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quinbay.quizbay.R;
import com.example.quinbay.quizbay.models.Quizbay_PastQuizes;

import java.util.ArrayList;

public class Quizbay_RecyclerView_PastQuizes_Quotes_Adapter extends RecyclerView.Adapter<Quizbay_RecyclerView_PastQuizes_Quotes_Adapter.PostHolder> {

    private ArrayList<String> sList;
    private Context mContext;

    public Quizbay_RecyclerView_PastQuizes_Quotes_Adapter(ArrayList<String> sList, Context mContext) {
        this.sList = sList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public Quizbay_RecyclerView_PastQuizes_Quotes_Adapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_past_quizes_quotes, parent, false);
        return new Quizbay_RecyclerView_PastQuizes_Quotes_Adapter.PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Quizbay_RecyclerView_PastQuizes_Quotes_Adapter.PostHolder holder, int position) {


        //get user postion
        String str = sList.get(position);

        //set id
//        holder.tv_quiz_rank.setText(position+1);
        holder.tv_past_quotes.setText(str);


    }


    @Override
    public int getItemCount() {
        return (sList == null) ? 0 : sList.size();
    }

    //class PostHolder extends RecyclerView.ViewHolder {


    //}




    public class PostHolder extends RecyclerView.ViewHolder{
        private final TextView tv_past_quotes;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            tv_past_quotes = itemView.findViewById(R.id.tv_pastquizes_quotes);

        }
    }
}
