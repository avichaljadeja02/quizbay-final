package com.example.crawler.service.impl;
import com.example.crawler.entity.CrawlerDTO;
import com.example.crawler.repository.CrawlerRepository;
import com.example.crawler.service.CrawlerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

     @Service
     public class CrawlerServiceImpl implements CrawlerService {
         private HashSet<String> links;
         private HashSet<String> links2;
         String answers[];
         String finalOptions[][];
         String question[];
         @Autowired
         CrawlerRepository crawlerRepository;
         public CrawlerServiceImpl() {
             links = new HashSet<String>();
             links2 = new HashSet<String>();
         }
         public void getPageLinks(String URL) {
             if (!links.contains(URL)) {
                 try {
                     if (links.add(URL)) {
                         System.out.println(URL);
                         Document document = Jsoup.connect(URL).get();
                         Elements linksOnPage = document.select("a[href]");
                         for (Element page : linksOnPage) {
                             String options = document.select("table.bix-tbl-options").toString().replaceAll("\\<.*?\\>", "");
                             options = options.replace("\n", "").replace("\r", "");
                             options = options.replaceAll("[ABCD.\n]", "");
                             options = options.replaceAll("       ", "");
                             answers = document.select("span.jq-hdnakqb").toString().replaceAll("\\<.*?\\>", "").split("\\r?\\n");
                             question = document.select("td.bix-td-qtxt").toString().replaceAll("\\<.*?\\>", "").split("\\r?\\n");
                             String[] strings = options.split("      ");
                             finalOptions = new String[question.length][4];
                             for (int i = 0; i < strings.length; i++) {
                                 finalOptions[i] = strings[i].split("    ");
                                 }
                             for (int i = 1; i < finalOptions.length; i++) {
                                 if (finalOptions[i][0] != null) {
                                     if (finalOptions[i].length == 4) {
                                         if (question[i].contains("&gt")) {
                                             continue;
                                          }
                                          else {
                                             System.out.println("Inside!!!");
                                             CrawlerDTO crawlingDTO = new CrawlerDTO();
                                             crawlingDTO.setQuizId((int) crawlerRepository.count() + 1);
                                             crawlingDTO.setAnswer(answers[i]);
                                             crawlingDTO.setOptions(finalOptions[i]);
                                             crawlingDTO.setQuestion(question[i]);
                                             crawlingDTO.setQuestionType("text");
                                             crawlingDTO.setAnswerType("single");
                                             String category = "";
                                             String categoryCheck = document.select("div.pagehead").toString().replaceAll("\\<.*?\\>", "");
                                             if (categoryCheck.contains("JAVA") || categoryCheck.contains("Computer") || categoryCheck.contains("Programming") || categoryCheck.contains("Engineering")||URL.contains("JAVA") || URL.contains("Computer") || URL.contains("Programming") || URL.contains("Engineering")) {
                                                 category = "computerScience";
                                             }
                                             if (categoryCheck.contains("arithmetic") || categoryCheck.contains("aptitude")||URL.contains("aptitude") || URL.contains("arithmetic")) {
                                                 category = "aptitude";
                                             }
                                             else if (categoryCheck.contains("computer") || categoryCheck.contains("programming")|| categoryCheck.contains("java") || URL.contains("computer") || URL.contains("programming")|| URL.contains("java")) {
                                                 category = "computerScience";
                                             }
                                             else if (categoryCheck.contains("knowledge") || categoryCheck.contains("general")|| categoryCheck.contains("gk")||URL.contains("knowledge") || URL.contains("general")|| URL.contains("gk")) {
                                                 category = "generalKnowledge";
                                             }
                                             else if (categoryCheck.contains("current") || categoryCheck.contains("affairs")|| categoryCheck.contains("daily")||URL.contains("current") || URL.contains("affairs")|| URL.contains("daily")) {
                                                 category = "currentAffairs";
                                             }
                                             if(category.equals("")==false) {
                                                 crawlingDTO.setCategory(category);
                                                 crawlingDTO.setQuestionSrc("");
                                                 System.out.println(crawlingDTO.getCategory());
                                                 crawlerRepository.save(crawlingDTO);
                                             }
                                             else {
                                                 continue;
                                             }
                                         }
                                     }
                                 }
                             }
                             getPageLinks(page.attr("abs:href"));
                         }
                     }
                 }
                 catch (Exception e) {
                     System.out.println(e);
                     }
             }
         }
         public void getPageLinksExam(String URL) {
             if (!links2.contains(URL)) {
                 try {
                     if (links2.add(URL)) {
                         System.out.println(URL);
                         Document document = Jsoup.connect(URL).get();
                         Elements linksOnPage = document.select("a[href]");
                         int count = 0;
                         while (count < 10000000) {
                             for (Element page : linksOnPage) {
                                 String options = document.select("div.form-inputs").toString().replaceAll("\\<.*?\\>", "");
                                 options = options.replaceAll("[ABCD.\n]", "");
                                 options = options.replace("\n", "").replace("\r", "");
                                 answers = document.select("strong").toString().replaceAll("\\<.*?\\>", "").replaceAll("[Option ]", "").split("\\r?\\n");
                                 question = document.select("div.question-main").toString().replaceAll("\\<.*?\\>", "").split("\\r?\\n");
                                 String[] strings = options.split("          ");
                                 String finalAnswers[] = new String [answers.length-1];
                                 for(int i = 0 ; i<answers.length-1; i++){
                                     finalAnswers[i] = answers[i];
                                     System.out.println(finalAnswers[i]);
                                 }
                                 finalOptions = new String[question.length][4];
                                 for (int i = 0; i < strings.length; i++) {
                                     finalOptions[i] = strings[i].split("       ");
                                 }
                                 for (int i = 1; i < finalOptions.length; i++) {
                                     if (finalOptions[i][0] != null) {
                                         if (finalOptions[i].length == 4) {
                                             if (question[i].contains("&gt")||answers[i].contains("quess")) {
                                                 continue;
                                                 }
                                                 else {
                                                    CrawlerDTO crawlingDTO = new CrawlerDTO();
                                                    crawlingDTO.setQuizId((int) crawlerRepository.count() + 1);
                                                    crawlingDTO.setAnswer(answers[i]);
                                                    crawlingDTO.setOptions(finalOptions[i]);
                                                    crawlingDTO.setQuestion(question[i]);
                                                    crawlingDTO.setQuestionType("text");
                                                    crawlingDTO.setAnswerType("single");
                                                    String category = "";
                                                    if (URL.contains("arithmetic") || URL.contains("aptitude")) {
                                                        category = "aptitude";
                                                    }
                                                    else if (URL.contains("computer") || URL.contains("programming")|| URL.contains("java")||URL.contains("engineering")) {
                                                        category = "computerScience";
                                                    }
                                                    else if (URL.contains("knowledge") || URL.contains("general")|| URL.contains("gk")) {
                                                        category = "generalKnowledge";
                                                    }
                                                    else if (URL.contains("current") || URL.contains("affairs")|| URL.contains("daily")) {
                                                        category = "currentAffairs";
                                                    }
                                                 System.out.println("here");
                                                    if(category.equals("")==false) {
                                                        crawlingDTO.setCategory(category);
                                                        crawlingDTO.setQuestionSrc("");
                                                        System.out.println(crawlingDTO.getCategory());
                                                        crawlerRepository.save(crawlingDTO);
                                                    }
                                                    else {
                                                        continue;
                                                    }
                                                    count++;
                                             }
                                         }
                                     }
                                 }
                                 getPageLinksExam(page.attr("abs:href"));
                             }
                         }
                     }
                 }
                 catch (Exception e) {
                     System.out.println(e);
                 }
             }
         }
         public List<CrawlerDTO> findByCategory (String category){
             return crawlerRepository.findByCategory(category);
             }
          @Override
          public void addQuestion(CrawlerDTO crawlerDTO) {
             System.out.println("adding!!");
             crawlerDTO.setQuizId((int) crawlerRepository.count() + 1);
             crawlerRepository.save(crawlerDTO);
             }
     }

