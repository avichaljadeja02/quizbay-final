package com.example.leaderBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class LeaderBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaderBoardApplication.class, args);
	}

}
