package com.ust.Capstone2.Repository;

import com.ust.Capstone2.Entity.SurveyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyDetailsRepository extends JpaRepository<SurveyDetails, Long>{


}


