/* references: Example of Collection group by, filtering and counting extracted from the following
 *               Sites
 * https://www.baeldung.com/java-groupingby-collector
 * https://mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
 * https://stackoverflow.com/questions/25441088/how-can-i-count-occurrences-with-groupby
 *
 *  */
package com.ust.Capstone2.WebController;


import com.ust.Capstone2.Entity.SurveyCreationDto;
import com.ust.Capstone2.Entity.SurveyDetails;
import com.ust.Capstone2.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/")
    public String WelcomePage(Model model) {
        return "index";
    }


    @GetMapping("/survey")
    public String surveyForm(Model model) {

        //Creating the list for questions
        List<SurveyDetails> questionsList = new ArrayList<SurveyDetails>();

        //Creating new objects for Survey Details class
        SurveyDetails surveyDetails1 = new SurveyDetails();
        SurveyDetails surveyDetails2 = new SurveyDetails();
        SurveyDetails surveyDetails3 = new SurveyDetails();
        SurveyDetails surveyDetails4 = new SurveyDetails();
        SurveyDetails surveyDetails5 = new SurveyDetails();
        SurveyDetails surveyDetails6 = new SurveyDetails();
        SurveyDetails surveyDetails7 = new SurveyDetails();

        //Using the setter to set the question
        surveyDetails1.setQuestion("Question 1: Are you looking forward to returning to work?");
        surveyDetails2.setQuestion("Question 2: Have you been more productive while working from home?");
        surveyDetails3.setQuestion("Question 3: Would you be willing to wear a face mask in the work place?");
        surveyDetails4.setQuestion("Question 4: Do you have concerns about commuting to work?");
        surveyDetails5.setQuestion("Question 5: Are you nervous about returning to work while the threat of Covid-19 remains?");
        surveyDetails6.setQuestion("Question 6: Is your communication good with your manager while working from home? ");
        surveyDetails7.setQuestion("Question 7: Do you have a healthy work and life balance while working from home?");

        //Adding questions to the questionList
        questionsList.add(surveyDetails1);
        questionsList.add(surveyDetails2);
        questionsList.add(surveyDetails3);
        questionsList.add(surveyDetails4);
        questionsList.add(surveyDetails5);
        questionsList.add(surveyDetails6);
        questionsList.add(surveyDetails7);

        //Creating an object for the wrapper class
        SurveyCreationDto surveyForm = new SurveyCreationDto();

        //Passing the questionsList to the wrapper class object
        surveyForm.setListOfQuestions(questionsList);

        model.addAttribute("surveyForm", surveyForm);

        return "survey";
    }

    @PostMapping("/saveSurveyDetails")
    public String saveSurveyDetails(@ModelAttribute("surveyForm") SurveyCreationDto surveyForm) {
        // save employee to database
        surveyService.saveAllSurveyDetails(surveyForm.getListOfQuestions());
        return "redirect:/thankyou";
    }


    @GetMapping("/thankyou")
    public String showThankyouForm(Model model) {
        return "thankyou";
    }

    @GetMapping("/result")
    public String showResultPage(Model model) {
        //Getting the data from the H2 database
        List<SurveyDetails> sdObj = surveyService.getAllSurveyDetails();
        String answer1 = "Yes";
        String answer2 = "No";
        Map<String, Integer> graphData = new TreeMap<>();

    //Sorting the questions
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        //filtering the answers and grouping by  questions count
        Map<String, Integer> tempData = sdObj.stream().filter(s -> s.getAnswer() != null && s.getAnswer().equalsIgnoreCase(answer1))
                .collect(Collectors.groupingBy(SurveyDetails::getQuestion,
                        Collectors.reducing(0, e -> 1, Integer::sum)));
        //sorting the above data tempData
        sortedMap.putAll(tempData);

        //Setting sorted tempData to graphData
        graphData = sortedMap;

        model.addAttribute("chartData", graphData);
        return "result";
    }


}