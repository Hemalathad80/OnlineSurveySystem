/*
package com.ust.Capstone2.Service;
import com.ust.Capstone2.Entity.SurveyDetails;
import com.ust.Capstone2.Repository.SurveyDetailsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

public class SurveyimplTest {
    @Autowired
    SurveyDetailsRepository surveyDetailsRepository;

    @Autowired
    Surveyimpl surveyimpl;

    @Test
    public void findAll_success() {
        List<SurveyDetails> allSurveyDetails = surveyimpl.getAllSurveyDetails();
        assertFalse(allSurveyDetails.isEmpty());
    }






    @Autowired
    Surveyimpl surveyImplTwo;

    @Test
    void getAllSurveyDetailsTest() {
        List<SurveyDetails> listOfDetails =  surveyImplTwo.getAllSurveyDetails();
        assertNotNull(listOfDetails);

    }



}
*/
