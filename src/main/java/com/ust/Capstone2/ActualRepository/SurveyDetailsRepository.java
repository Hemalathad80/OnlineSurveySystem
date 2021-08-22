package com.ust.Capstone2.ActualRepository;

import com.ust.Capstone2.Entity.SurveyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyDetailsRepository extends JpaRepository<SurveyDetails, Long>{


}


