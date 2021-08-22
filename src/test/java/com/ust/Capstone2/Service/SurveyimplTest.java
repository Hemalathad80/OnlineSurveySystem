
package com.ust.Capstone2.Service;

import com.ust.Capstone2.Entity.SurveyDetails;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import org.springframework.boot.web.server.LocalServerPort;

public class SurveyimplTest {


    Surveyimpl surveyimpl = new Surveyimpl();

    @Test
    public void findAll_success() {
        List<SurveyDetails> allSurveyDetails = surveyimpl.getAllSurveyDetails();
        assertFalse(allSurveyDetails.isEmpty());
    }

    Surveyimpl surveyImplTwo = new Surveyimpl();

    @Test
    void getAllSurveyDetailsTest() {
        List<SurveyDetails> listOfDetails =  surveyImplTwo.getAllSurveyDetails();
        assertNotNull(listOfDetails);

    }



}
