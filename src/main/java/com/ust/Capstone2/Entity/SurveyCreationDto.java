package com.ust.Capstone2.Entity;

import java.util.ArrayList;
import java.util.List;

//Wrapper class for the list of questions
public class SurveyCreationDto {

    private List<SurveyDetails> listOfQuestions = new ArrayList<>(7);

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
