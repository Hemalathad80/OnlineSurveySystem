package com.ust.Capstone2.Entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "SurveyDetails")
public class SurveyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question", columnDefinition="VARCHAR(1024)")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "launchDate")
    private String launchDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    //Formatting the date and time using DateFormatter
    public void setLaunchDate(String launchDate) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        launchDate = now.format(formatter);
        this.launchDate = launchDate;
    }
}