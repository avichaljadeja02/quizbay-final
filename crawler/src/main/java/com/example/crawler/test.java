package com.example.crawler;



import com.example.crawler.entity.CrawlerDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class test
{
        private HashSet<String> links2;
        String answers[];
        String finalOptions[][];
        String question[];

        public test() {
            links2 = new HashSet<String>();
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
//                                System.out.println(finalAnswers[i]);
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
                                        } else {
                                            CrawlerDTO crawlingDTO = new CrawlerDTO();
//                                            crawlingDTO.setQuizId((int) crawlerRepository.count() + 1);
                                            crawlingDTO.setAnswer(answers[i]);
                                            crawlingDTO.setOptions(finalOptions[i]);
                                            crawlingDTO.setQuestion(question[i]);
                                            crawlingDTO.setQuestionType("text");
                                            crawlingDTO.setAnswerType("single");
                                            String category = "";
                                            if (URL.contains("arithmetic") || URL.contains("aptitude")) {
                                                category = "aptitude";
                                            }
                                            else if (URL.contains("computer") || URL.contains("programming")|| URL.contains("java")) {
                                                category = "computerScience";
                                            }
                                            else if (URL.contains("knowledge") || URL.contains("general")|| URL.contains("gk")) {
                                                category = "generalKnowledge";
                                            }
                                            else if (URL.contains("current") || URL.contains("affairs")|| URL.contains("daily")) {
                                                category = "currentAffairs";
                                            }


                                            crawlingDTO.setCategory(category);
                                            crawlingDTO.setQuestionSrc("");
//                                            System.out.println(crawlingDTO.getCategory());
//                                            crawlerRepository.save(crawlingDTO);
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


        public static void main(String[] args) {
            new test().getPageLinksExam("https://www.examveda.com/arithmetic-ability/practice-mcq-question-on-average/");
        }

    }

