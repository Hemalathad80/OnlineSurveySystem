
package com.ust.Capstone2.Service;

import com.ust.Capstone2.Entity.SurveyDetails;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SurveyimplTest {

    @Autowired
    Surveyimpl surveyimpl;

    @Test
    public void findAll_success() {
        List<SurveyDetails> allSurveyDetails = surveyimpl.getAllSurveyDetails();

        assertThat(allSurveyDetails).isNotNull();
    }

}





