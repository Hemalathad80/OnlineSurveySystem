package com.ust.Capstone2.Service;

import com.ust.Capstone2.Entity.SurveyDetails;
import com.ust.Capstone2.ActualRepository.SurveyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Surveyimpl implements SurveyService {

    @Autowired
    private SurveyDetailsRepository surveyDetailsRepository;

    @Override
    public void saveSurveyDetails(SurveyDetails surveyDetails) {
        this.surveyDetailsRepository.save(surveyDetails);

    }

    @Override
    public void saveAllSurveyDetails(List<SurveyDetails> surveyDetailsList) {
        this.surveyDetailsRepository.saveAll(surveyDetailsList);
    }

    @Override
    public SurveyDetails getById(long id) {
        return surveyDetailsRepository.getById(id);
    }

    @Override
    public List<SurveyDetails> getAllSurveyDetails(){

        return this.surveyDetailsRepository.findAll();
    }



}
