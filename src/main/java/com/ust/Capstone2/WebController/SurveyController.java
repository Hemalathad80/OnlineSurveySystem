package com.ust.Capstone2.WebController;


import com.ust.Capstone2.Entity.SurveyDetails;
import com.ust.Capstone2.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;


    @GetMapping("/survey")
    public String surveyForm(Model model) {

        List<SurveyDetails> listOfQuestions = new ArrayList<SurveyDetails>();

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
        surveyDetails3.setQuestion("Question 3: Would you be willing to wear a face mask?");
        surveyDetails4.setQuestion("Question 4: Have you been diagnosed with Covid-19 while away from work?");
        surveyDetails6.setQuestion("Question 6: Are you nervous about returning to work while the threat of Covid-19 remains?");
        surveyDetails7.setQuestion("Question 7: If you have been working from home, would you prefer to continue doing so? ");
        surveyDetails8.setQuestion("Question 8: On a scale of 1 – 5, how would you rate your communication with your manager while working from home? ");
        surveyDetails9.setQuestion("Question 9:Are you able to be flexible in your start, break, and finish times to account for social distancing and limiting the number of employees on-site at a single time?Do you have any additional concerns about returning to work? If so, please tell us what they are…  ");

        listOfQuestions.add(surveyDetails1);
        listOfQuestions.add(surveyDetails2);
        listOfQuestions.add(surveyDetails3);
        listOfQuestions.add(surveyDetails4);
        listOfQuestions.add(surveyDetails5);
        listOfQuestions.add(surveyDetails6);
        listOfQuestions.add(surveyDetails7);
        listOfQuestions.add(surveyDetails8);
        listOfQuestions.add(surveyDetails9);

        model.addAttribute("surveyList", listOfQuestions);

        return "survey";
    }



    @PostMapping("/saveSurveyDetails")
    public String saveSurveyDetails(@ModelAttribute("surveyList") SurveyDetails surveyList) {
        // save employee to database

            surveyService.saveSurveyDetails(surveyList);
            return "redirect:/thankyou/" + surveyList.getId();
        }
    }

    @GetMapping("/thankyou/{id}")
    public String showThankyouForm(@PathVariable(value = "id") long id, Model model) {
        //create model attribute to bind form data
        SurveyDetails surveyDetails = surveyService.getById(id);
        model.addAttribute("SurveyDetails", surveyDetails);
        return "thankyou";
    }



}