package com.example.leaderBoard.repository;

import com.example.leaderBoard.entity.LeaderBoard;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaderBoardRepository extends CrudRepository<LeaderBoard,String>{
    List<LeaderBoard> getLeaderBoardByQuizId(int quizId);
    List<LeaderBoard> getLeaderBoardByUserId(String userId);

}

