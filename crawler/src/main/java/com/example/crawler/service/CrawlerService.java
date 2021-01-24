package com.example.crawler.service;



import com.example.crawler.entity.CrawlerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrawlerService {
    void getPageLinks();
    List<CrawlerDTO> findByCategory(String category);
}
