package com.example.crawler.controller;


import com.example.crawler.entity.CrawlerDTO;
import com.example.crawler.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "quizbay/crawl")
public class CrawlerController  {

    @Autowired
    CrawlerService crawlerService;

    @PostMapping(value = "/")
    public void addCrawledData(){
        crawlerService.getPageLinks();
    }
    @GetMapping(value = "/findByCategory/{category}")
    public List<CrawlerDTO> findByCategory(@PathVariable String category){
        return crawlerService.findByCategory(category);
    }

}
