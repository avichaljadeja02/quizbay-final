package com.example.demoPostGres.controller;

import com.example.demoPostGres.entity.Question;
import com.example.demoPostGres.entity.QuizDetails;
import com.example.demoPostGres.entity.UserDetails;
import com.example.demoPostGres.entity.UserScores;
import com.example.demoPostGres.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "quizbay/user")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/addUser")
    public void addUser(@RequestBody UserDetails userDetails){
        userService.addUser(userDetails);
    }

    @CrossOrigin
    @PostMapping(value = "/uploadToQuiz")
    public void uploadToQuizDetails(@RequestBody QuizDetails quizDetails){
        userService.uploadToQuizDetails(quizDetails);
    }

    @CrossOrigin
    @GetMapping(value = "/startQuiz/{userId}/{quizId}")
    public Question startQuiz(@PathVariable String userId,@PathVariable int quizId){
        return userService.startQuiz(userId,quizId);
    }


    @CrossOrigin
    @PostMapping(value = "/continueQuiz")
    public Question continueQuiz(@RequestBody UserScores userScores){
        System.out.println("abc");
        Question question = userService.continueQuiz(userScores);
        System.out.println(question.getCorrectAnswer());
        return question;
    }

    @CrossOrigin
    @PostMapping(value = "")
    public void endQuiz(@RequestBody UserScores userScores){
        userService.endQuiz(userScores);
    }
}
