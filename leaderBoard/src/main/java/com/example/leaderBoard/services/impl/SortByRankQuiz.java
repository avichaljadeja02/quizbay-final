package com.example.leaderBoard.services.impl;


import com.example.leaderBoard.entity.LeaderBoard;

import java.util.Comparator;

public class SortByRankQuiz implements Comparator<LeaderBoard> {
    public int compare(LeaderBoard a, LeaderBoard b){
        return b.getScore()-a.getScore();
    }
}
