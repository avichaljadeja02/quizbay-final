package com.example.leaderBoard.repository;

import com.example.leaderBoard.entity.OverallLeaders;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OverallLeaderBoardRepository extends CrudRepository<OverallLeaders,String> {
    OverallLeaders findByUserId(String Id);
    List<OverallLeaders> findAll();

}
