package com.example.crawler.service;



import com.example.crawler.entity.CrawlerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrawlerService {
    void getPageLinks(String URL);
    void getPageLinksExam(String URL);
    List<CrawlerDTO> findByCategory(String category);
    void addQuestion(CrawlerDTO crawlerDTO);
}
