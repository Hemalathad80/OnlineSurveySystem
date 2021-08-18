package com.ust.Capstone2.Service;

import com.ust.Capstone2.Entity.SurveyDetails;

import java.util.List;

public interface SurveyService {

    void saveSurveyDetails(SurveyDetails surveyDetails);

    SurveyDetails getById(long id);

    void saveAllSurveyDetails(List<SurveyDetails> surveyDetailsList);
}

