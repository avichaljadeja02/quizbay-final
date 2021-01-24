package com.example.contestCreation.Controller;

import com.example.contestCreation.Model.MasterRating;
import com.example.contestCreation.Model.Questions;
import com.example.contestCreation.Model.QuizDetails;
import com.example.contestCreation.Model.QuizMaster;
import com.example.contestCreation.Services.ContestCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "quizbay/contest")
public class MyController {

    @Autowired
    ContestCreationService contestCreationService;

    @CrossOrigin
    @PostMapping(value = "/uploadQuiz")
    public void uploadQuiz(@RequestBody QuizDetails quizDetails){
        contestCreationService.saveQuiz(quizDetails);
    }

    @CrossOrigin
    @PostMapping(value = "/addMaster")
    public void addMaster(@RequestBody QuizMaster quizMaster){
        contestCreationService.addMaster(quizMaster);
    }

    @CrossOrigin
    @GetMapping(value = "/getQuizDetails/{masterId}")
    public List<QuizDetails> getQuizDetails(@PathVariable String masterId){
        return contestCreationService.getQuizDetails(masterId);
    }

    @CrossOrigin
    @GetMapping(value = "/getOneQuiz/{masterId}/{quizId}")
    public QuizDetails getOneQuizDetails(@PathVariable String masterId,@PathVariable int quizId){
        return contestCreationService.getSingleQuizDetails(masterId,quizId);
    }

    @CrossOrigin
    @PostMapping(value = "/updateMasterRating")
    public void updateMasterRating(@RequestBody MasterRating masterRating){
        contestCreationService.updateMasterRating(masterRating.masterId,masterRating.rating);
    }

    @CrossOrigin
    @GetMapping(value = "/getRating/{masterId}")
    public double getRatingOfMaster(@PathVariable String masterId){
        return contestCreationService.getRating(masterId);
    }

    @CrossOrigin
    @GetMapping(value = "/getActiveQuizzes/{category}")
    public List<QuizDetails> getActiveQuizzes(@PathVariable String category){
        return contestCreationService.getActiveQuizzes(category);
    }

    @CrossOrigin
    @GetMapping(value = "/getMasterPastQuizzes/{masterId}" )
    public List<QuizDetails> getAllPastQuizzes(@PathVariable String masterId){
        return contestCreationService.getPastQuizzesByMaster(masterId);
    }

    @CrossOrigin
    @GetMapping(value = "/getMasterActiveQuizzes/{masterId}" )
    public List<QuizDetails> getAllActiveQuizzes(@PathVariable String masterId){
        return contestCreationService.getActiveQuizzesByMaster(masterId);
    }

    @CrossOrigin
    @GetMapping(value = "/getMasterFutureQuizzes/{masterId}" )
    public List<QuizDetails> getAllFutureQuizzes(@PathVariable String masterId){
        return contestCreationService.getFutureQuizzesByMaster(masterId);
    }

    @CrossOrigin
    @GetMapping(value = "/getDynamicQuizzes/{masterId}")
    public List<QuizDetails> getDynamicQuizzes(@PathVariable String masterId){
        return contestCreationService.getDynamicQuizzes(masterId);
    }

    @CrossOrigin
    @GetMapping(value = "/getByCategory/{category}")
    public List<QuizDetails> getByCategory(@PathVariable String category){
        return contestCreationService.getByCategory(category);
    }

    @CrossOrigin
    @GetMapping(value = "/getByQues/{quizId}/{quesId}")
    public Questions getByQue(@PathVariable int quizId, @PathVariable int quesId){
        System.out.println("abc");
        return contestCreationService.getByQue(quizId,quesId);
    }

}