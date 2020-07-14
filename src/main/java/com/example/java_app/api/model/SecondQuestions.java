package com.example.java_app.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SecondQuestions")
public class SecondQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String question;
    private String min;
    private String max;
    public SecondQuestions(){}

    public SecondQuestions(String question,String min,String max)
    {
        this.question = question;
        this.min = min;
        this.max = max;
        
    }

    public SecondQuestions(int id,String question,String min,String max)
    {
        this(question,min,max);
    }

    public int getId() { return id;}

    public String getQuestion() { return question;}

    public String getMin() { return min;}

    public String getMax() { return max;}

    public void setId(int id)
    {
        this.id = id;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public void setMin(String min)
    {
        this.min = min;
    }

    public void setMax(String max)
    {
        this.max = max;
    }


}