package com.example.java_app.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity

public class Person{
    @GeneratedValue

    @Id
    private Long id;

    private String login;

    private String password;

    private String email;

    private String role = "USER";

    public Person(){}

    public Person(String login,String password,String email,String role)
    {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
      
    }

    public Person(Long id,String login,String password,String email,String role)
    {
        this(login,password,email,role);
        if(id!= null)
        {
            this.id = id;
        }
    }

    public Long getId() { return id;}

    public String getLogin() { return login;}

    public String getPassword() { return password;}

    public String getEmail() { return email;}

    public String getRole() { return role;}

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
 
}