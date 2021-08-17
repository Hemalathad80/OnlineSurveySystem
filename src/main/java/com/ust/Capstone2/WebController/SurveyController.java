package com.ust.Capstone2.WebController;


import com.ust.Capstone2.Entity.SurveyDetails;
import com.ust.Capstone2.Service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SurveyController {

    @Autowired
    private SurveyService surveyService;


    @GetMapping("/survey")
    public String surveyForm(Model model) {

        SurveyDetails surveyDetails = new SurveyDetails();
        SurveyDetails surveyDetails1 = new SurveyDetails();
       surveyDetails.setQuestion("Are you looking forward to returning to work?");
        surveyDetails1.setQuestion("Have you been equally productive, less productive, or more productive while working from home?");
        model.addAttribute("survey", surveyDetails);

        return "survey";
    }




    @PostMapping("/saveSurveyDetails")
    public String saveSurveyDetails(@ModelAttribute("surveyDetails") SurveyDetails surveyDetails) {
        // save employee to database
        surveyService.saveSurveyDetails(surveyDetails);
        return "redirect:/thankyou/" + surveyDetails.getId();
    }

    @GetMapping("/thankyou/{id}")
    public String showThankyouForm(@PathVariable(value = "id") long id, Model model) {
        //create model attribute to bind form data
        SurveyDetails surveyDetails = surveyService.getById(id);
        model.addAttribute("SurveyDetails", surveyDetails);
        return "thankyou";
    }


}