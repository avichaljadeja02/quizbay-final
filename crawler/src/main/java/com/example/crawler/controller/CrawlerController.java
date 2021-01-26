package com.example.crawler.controller;


import com.example.crawler.entity.CrawlerDTO;
import com.example.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "quizbay/crawl")
public class CrawlerController  {

    @Autowired
    CrawlerService crawlerService;

    @CrossOrigin
    @PostMapping(value = "/")
    public void addCrawledData(){
        crawlerService.getPageLinks("https://www.indiabix.com/java-programming/language-fundamentals/");
    }
    @PostMapping(value = "/crawl2")
    public void addCrawledData2(){
        crawlerService.getPageLinksExam("https://www.examveda.com/arithmetic-ability/practice-mcq-question-on-average/");
    }
    @CrossOrigin
    @GetMapping(value = "/findByCategory/{category}")
    public List<CrawlerDTO> findByCategory(@PathVariable String category){
        return crawlerService.findByCategory(category);
    }
    @CrossOrigin
    @PostMapping(value="/addQuestion")
    public void addQuestion(@RequestBody CrawlerDTO crawlerDTO){
        crawlerService.addQuestion(crawlerDTO);
    }

}
