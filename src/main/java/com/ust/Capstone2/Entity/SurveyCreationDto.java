package com.ust.Capstone2.Entity;

import java.util.ArrayList;
import java.util.List;

public class SurveyCreationDto {

    private List<SurveyDetails> listOfQuestions = new ArrayList<>(9);

    public void addSurvey(SurveyDetails sdObj){
        this.listOfQuestions.add(sdObj);
    }

    public List<SurveyDetails> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(List<SurveyDetails> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }
}
