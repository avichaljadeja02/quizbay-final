package com.example.leaderBoard.services;
import com.example.leaderBoard.entity.LeaderBoard;
import com.example.leaderBoard.entity.OverallLeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaderBoardServices {
    List<OverallLeaders> getOverallLeaderBoard ();
    List<LeaderBoard> getLeaderBoardByQuizId(int quizId);
    List<LeaderBoard> getLeaderBoardByUserId(String userId);
    void uploadToLeaderBoard(LeaderBoard object);
}
