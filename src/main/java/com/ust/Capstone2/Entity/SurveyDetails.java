package com.ust.Capstone2.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SurveyDetails")
public class SurveyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime launchDate;


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

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }
}
