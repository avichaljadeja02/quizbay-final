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
import com.example.quinbay.quizbay.Response;

import java.util.ArrayList;

public class Quizbay_RecyclerView_HomeLeaderboard_Adapter extends RecyclerView.Adapter<Quizbay_RecyclerView_HomeLeaderboard_Adapter.PostHolder> {




    private ArrayList<Response> mList;
    private Context mContext;

    public Quizbay_RecyclerView_HomeLeaderboard_Adapter(ArrayList<Response> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Quizbay_RecyclerView_HomeLeaderboard_Adapter.PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quizbay_activity_leaderboard_eachuser, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Quizbay_RecyclerView_HomeLeaderboard_Adapter.PostHolder holder, int position) {


        //get user postion
        Response quizbay_user_profile = mList.get(position);

        //set id
        holder.tv_rank.setText(String.valueOf(quizbay_user_profile.getRank()));
        //set userr name
        holder.tv_user_name.setText(quizbay_user_profile.getUserName());
        //set user score
        holder.tv_user_score.setText(String.valueOf(quizbay_user_profile.getTotalScore()));
          //ser user emoji
        if(quizbay_user_profile.getTotalScore()>200)
        holder.iv_emoji.setBackgroundResource(R.drawable.beeremoji);
        else if(quizbay_user_profile.getTotalScore()>100 && quizbay_user_profile.getTotalScore()<200)
            holder.iv_emoji.setBackgroundResource(R.drawable.sademoji);
        else if(quizbay_user_profile.getTotalScore()<100)
            holder.iv_emoji.setBackgroundResource(R.drawable.surprised_emoji);
        //set cardview
        if(position==0) {
            holder.cv_leader.setCardBackgroundColor(Color.parseColor("#ffd700"));
           // holder.tv_leader_winner.setText(quizbay_user_profile.getUserName());
        }
        if(position==1)
            holder.cv_leader.setCardBackgroundColor(Color.parseColor("#C0C0C0"));
        if(position==2)
            holder.cv_leader.setCardBackgroundColor(Color.parseColor("#cd7f32"));



      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: make new activity pass intent with serializable object
                // Intent intent = new Intent(mContext, ShowEmployeeActivity.class);
                //intent.putExtra("employee", employee);
                //mContext.startActivity(intent);
            }
        });*/

    }
    @Override
    public int getItemCount() {
        return (mList == null) ? 0 : mList.size();
    }

    //class PostHolder extends RecyclerView.ViewHolder {


    //}




    public class PostHolder extends RecyclerView.ViewHolder{
        private final TextView tv_rank;
        private final TextView tv_user_name;
        private final TextView tv_user_score;
        private final ImageView iv_emoji;
        private final CardView cv_leader;
        //private final TextView tv_leader_winner;
        public PostHolder(@NonNull View itemView) {
            super(itemView);

            tv_user_name = itemView.findViewById(R.id.tv_lb_username);
            tv_user_score = itemView.findViewById(R.id.tv_lb_score);
            tv_rank = itemView.findViewById(R.id.tv_lb_rank);
            iv_emoji = itemView.findViewById(R.id.iv_leaderboard_eachuser_emoji);
            cv_leader = itemView.findViewById(R.id.cv_leaderboard_eachuser);
            //tv_leader_winner = itemView.findViewById(R.id.tv_leaderboard_winner_name);
        }
    }
}
