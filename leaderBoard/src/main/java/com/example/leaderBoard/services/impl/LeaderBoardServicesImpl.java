package com.example.leaderBoard.services.impl;

import com.example.leaderBoard.entity.LeaderBoard;
import com.example.leaderBoard.entity.OverallLeaders;
import com.example.leaderBoard.repository.LeaderBoardRepository;
import com.example.leaderBoard.repository.OverallLeaderBoardRepository;
import com.example.leaderBoard.services.LeaderBoardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class LeaderBoardServicesImpl implements LeaderBoardServices {
    @Autowired
    LeaderBoardRepository leaderRepository;

    @Autowired
    OverallLeaderBoardRepository overallrepository;

    @Override
    public List<OverallLeaders> getOverallLeaderBoard() {
        List<OverallLeaders> object=overallrepository.findAll();
        int sizeOfObject=object.size();
        Collections.sort(object,new SortByRankUser());
        for(int i=1;i<sizeOfObject;i++) {
            OverallLeaders obj=object.get(i);
            if( (obj.getTotalScore()-object.get(i-1).getTotalScore())==0){
                obj.setRank(i);
            }
            else
                obj.setRank(i+1);        }
        return object;
    }

   @Override
    public List<LeaderBoard> getLeaderBoardByQuizId(int quizId) {
       List<LeaderBoard> object=leaderRepository.getLeaderBoardByQuizId(quizId);
       int sizeOfObject=object.size();
       Collections.sort(object,new SortByRankQuiz());
       for(int i=1;i<sizeOfObject;i++) {
           LeaderBoard obj=object.get(i);
           if( (obj.getScore()-object.get(i-1).getScore())==0){
               obj.setRank(i);
           }
           else
               obj.setRank(i+1);
       }
       return object;
    }

    @Override
    public List<LeaderBoard> getLeaderBoardByUserId(String userId) {
        List<LeaderBoard> object=leaderRepository.getLeaderBoardByUserId(userId);
        int sizeOfObject=object.size();
        Collections.sort(object,new SortByRankQuiz());
        for(int i=1;i<sizeOfObject;i++) {
            LeaderBoard obj=object.get(i);
            if( (obj.getScore()-object.get(i-1).getScore())==0){
                obj.setRank(i);
            }
            else
                obj.setRank(i+1);
        }
        return object;
    }

    @Override
    public void uploadToLeaderBoard(LeaderBoard object) {
        object.setRank(1);
        leaderRepository.save(object);
        if(!overallrepository.existsById(object.getUserId())){
            OverallLeaders obj=new OverallLeaders();
            obj.setUserId(object.getUserId());
            obj.setUserName(object.getUserName());
            obj.setTotalScore(object.getScore());
            obj.setRank(1);
            overallrepository.save(obj);
        }
        else{
                OverallLeaders obj = overallrepository.findByUserId(object.getUserId());
                obj.setTotalScore(obj.getTotalScore()+object.getScore());
                overallrepository.save(obj);
        }
    }
}
