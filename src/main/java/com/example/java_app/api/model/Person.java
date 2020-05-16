package com.example.java_app.api.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;




@Entity
@Table(name = "Person")
public class Person{
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true)
    private String username;
    @JsonProperty
    private String password;
    private String email;
    private String roles;

    public Person(){}

    public Person(String username,String password,String email,String roles)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
      
    }

    public Person(int id,String username,String password,String email,String roles)
    {
        this(username,password,email,roles);
    }

    public int getId() { return id;}

    public String getUsername() { return username;}

    public String getPassword() { return password;}

    public String getEmail() { return email;}

    public String getRoles() { return roles;}

    public void setId(int id)
    {
        this.id = id;
    }

    public void setUsername(String login)
    {
        this.username = login;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setRoles(String roles)
    {
        this.roles = roles;
    }
    
}