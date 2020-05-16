package com.example.java_app.api.model;

import javax.persistence.*;

@Entity
@Table(name = "Questions")
public class Questions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String question;

    public Questions(){}

    public Questions(String question)
    {
        this.question = question;
      
    }

    public Questions(int id,String question)
    {
        this(question);
    }

    public int getId() { return id;}

    public String getQuestion() { return question;}

    public void setId(int id)
    {
        this.id = id;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }
}