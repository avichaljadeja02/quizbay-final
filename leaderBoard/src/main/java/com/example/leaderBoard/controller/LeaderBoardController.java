package com.example.leaderBoard.controller;

import com.example.leaderBoard.entity.OverallLeaders;
import com.example.leaderBoard.services.LeaderBoardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.leaderBoard.entity.LeaderBoard;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/quizbay/leaderboard")
public class LeaderBoardController {
    @Autowired
    LeaderBoardServices leaderServices;

    @GetMapping(value = "/quiz/{quizId}")
    public List<LeaderBoard> getLeaderBoardByQuizId(@PathVariable("quizId") int quizId) {
        System.out.println("abcsd");
        return leaderServices.getLeaderBoardByQuizId(quizId);
    }

    @PostMapping(value = "/upload")
    public void uploadToLeaderBoard(@RequestBody LeaderBoard listofscores) {
         leaderServices.uploadToLeaderBoard(listofscores);
    }

    @GetMapping(value = "/user/{userId}")
    public List<LeaderBoard> getLeaderBoardByUserId(@PathVariable("userId") String userId) {
        return leaderServices.getLeaderBoardByUserId(userId);
    }

    @GetMapping(value = "/overallleaderboard")
    public List<OverallLeaders> getOverallLeaderBoard() {
        System.out.println("abc");
        return leaderServices.getOverallLeaderBoard();
    }

}
