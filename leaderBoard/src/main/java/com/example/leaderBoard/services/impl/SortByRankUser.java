package com.example.leaderBoard.services.impl;

import com.example.leaderBoard.entity.OverallLeaders;

import java.util.Comparator;

public class SortByRankUser implements Comparator<OverallLeaders> {
    public int compare(OverallLeaders a, OverallLeaders b){
        return b.getTotalScore()-a.getTotalScore();
    }
}
