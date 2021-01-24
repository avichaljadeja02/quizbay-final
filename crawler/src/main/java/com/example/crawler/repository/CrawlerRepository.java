package com.example.crawler.repository;

import com.example.crawler.entity.CrawlerDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CrawlerRepository extends MongoRepository<CrawlerDTO,Integer> {
    long count();
    List<CrawlerDTO> findByCategory(String category);
}