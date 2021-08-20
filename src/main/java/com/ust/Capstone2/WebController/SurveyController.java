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


    @GetMapping("/survey")
    public String surveyForm(Model model) {

        List<SurveyDetails> questionsList = new ArrayList<SurveyDetails>();

        SurveyDetails surveyDetails1 = new SurveyDetails();
        SurveyDetails surveyDetails2 = new SurveyDetails();
        SurveyDetails surveyDetails3 = new SurveyDetails();
        SurveyDetails surveyDetails4 = new SurveyDetails();
        SurveyDetails surveyDetails5 = new SurveyDetails();
        SurveyDetails surveyDetails6 = new SurveyDetails();
        SurveyDetails surveyDetails7 = new SurveyDetails();
        SurveyDetails surveyDetails8 = new SurveyDetails();
        SurveyDetails surveyDetails9 = new SurveyDetails();

        surveyDetails1.setQuestion("Question 1: Are you looking forward to returning to work?");
        surveyDetails2.setQuestion("Question 2: Have you been more productive while working from home?");
        surveyDetails3.setQuestion("Question 3: Would you be willing to wear a face mask in the work place?");
        surveyDetails4.setQuestion("Question 4: Have you been diagnosed with Covid-19 while away from work?");
        surveyDetails5.setQuestion("Question 5: Do you have concerns about commuting to work?");
        surveyDetails6.setQuestion("Question 6: Are you nervous about returning to work while the threat of Covid-19 remains?");
        surveyDetails7.setQuestion("Question 7: If you have been working from home, would you prefer to continue doing so? ");
        surveyDetails8.setQuestion("Question 8: Is your communication good with your manager while working from home? ");
        surveyDetails9.setQuestion("Question 9: Do you have a healthy work and life balance while working from home?");

        questionsList.add(surveyDetails1);
        questionsList.add(surveyDetails2);
        questionsList.add(surveyDetails3);
        questionsList.add(surveyDetails4);
        questionsList.add(surveyDetails5);
        questionsList.add(surveyDetails6);
        questionsList.add(surveyDetails7);
        questionsList.add(surveyDetails8);
        questionsList.add(surveyDetails9);

        SurveyCreationDto surveyForm = new SurveyCreationDto();
        surveyForm.setListOfQuestions(questionsList);

        model.addAttribute("surveyForm", surveyForm);
        //model.addAttribute("questions",questionsList);

        return "survey";
    }

    @PostMapping("/saveSurveyDetails")
    public String saveSurveyDetails(@ModelAttribute("surveyForm") SurveyCreationDto surveyForm) {
        // save employee to database
        /*for (SurveyDetails survey : listOfQuestions) {
            surveyService.saveSurveyDetails(survey);
        }
        System.out.println("saveSurveyDetails() is called" + surveyForm.getListOfQuestions() );
        for( SurveyDetails s : surveyForm.getListOfQuestions()) {
            System.out.println("The answer is" + s.toString());
        }*/
        surveyService.saveAllSurveyDetails(surveyForm.getListOfQuestions());
        //surveyService.saveSurveyDetails(surveyForm);
        return "redirect:/thankyou";
    }


    @GetMapping("/thankyou")
    public String showThankyouForm(Model model) {
        //create model attribute to bind form data
        return "thankyou";
    }

    @GetMapping("/result")
    public String showResultPage(Model model) {
        List<SurveyDetails> sdObj = surveyService.getAllSurveyDetails();
        //Map<String, Integer> graphData = new TreeMap<>();

        Map<SurveyDetails, Long> graphData =
                sdObj.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );


        //graphData.put(sd.getQuestion(), counterForYes);
        //graphData.put(sd.getQuestion(), counterForNo);

        return "result";
    }

}