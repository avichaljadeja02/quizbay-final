package com.example.crawler.service.impl;

import com.example.crawler.entity.CrawlerDTO;
import com.example.crawler.repository.CrawlerRepository;
import com.example.crawler.service.CrawlerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;


@Service
public class CrawlerServiceImpl implements CrawlerService {
    private HashSet<String> links;
    String answers[];
    String finalOptions[][];
    String question[];

    @Autowired
    CrawlerRepository crawlerRepository;

    public CrawlerServiceImpl() {
        links = new HashSet<String>();
    }


    public void getPageLinks(){
        System.out.println("Inside ");

            String URLs[] = {
                    "https://www.indiabix.com/logical-reasoning/analogies/",
                    "https://www.indiabix.com/aptitude/problems-on-numbers/",
                    "https://www.indiabix.com/aptitude/problems-on-trains/",
                    "https://www.indiabix.com/aptitude/alligation-or-mixture/",
                    "https://www.indiabix.com/aptitude/time-and-distance/",
                    "https://www.indiabix.com/aptitude/boats-and-streams/",
                    "https://www.indiabix.com/aptitude/ratio-and-proportion/"
            };
            for (int i2 = 0; i2 < URLs.length; i2++) {
                System.out.println(URLs[i2]);
                String URL = URLs[i2];
                if (!links.contains(URL)) {
                    try {
                        if (links.add(URL)) {
                            System.out.println(URL);
                        }
                        Document document = Jsoup.connect(URL).get();
                        String options = document.select("table.bix-tbl-options").toString().replaceAll("\\<.*?\\>", "");
                        options = options.replace("\n", "").replace("\r", "");
                        options = options.replaceAll("[ABCD.\n]", "");
                        options = options.replaceAll("       ", "");
                        answers = document.select("span.jq-hdnakqb").toString().replaceAll("\\<.*?\\>", "").split("\\r?\\n");
                        question = document.select("td.bix-td-qtxt").toString().replaceAll("\\<.*?\\>", "").split("\\r?\\n");
                        String[] strings = options.split("     ");
                        finalOptions = new String[question.length][4];
                        System.out.println(strings.length);
                        for (int i = 0; i < 4; i++) {
                            finalOptions[i] = strings[i].split("  ");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (int i = 1; i < finalOptions.length; i++) {
                        CrawlerDTO crawlingDTO = new CrawlerDTO();
                        crawlingDTO.setQuizId((int) crawlerRepository.count() + 1);
                        crawlingDTO.setAnswer(answers[i]);
                        crawlingDTO.setOptions(finalOptions[i]);
                        crawlingDTO.setQuestion(question[i]);
                        crawlingDTO.setQuestionType("text");
                        crawlingDTO.setAnswerType("single");
                        crawlingDTO.setCategory("Aptitude");
                        crawlerRepository.insert(crawlingDTO);
                    }
                }
        }
        }
        public List<CrawlerDTO> findByCategory(String category){
            return crawlerRepository.findByCategory(category);
        }
    }

