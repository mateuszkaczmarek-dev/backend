package com.example.java_app.api.controller;

import java.util.List;

import javax.validation.ValidationException;

//import com.example.java_app.Mapper;
import com.example.java_app.api.db.PersonRepository;
import com.example.java_app.api.model.Person;





//import com.example.java_app.api.viewmodel.PersonViewModel;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController("/api")
@CrossOrigin(origins = "*")
public class PersonController {

    
    private PersonRepository personRepository;


    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
        
    }

    @GetMapping("/all")
    public List<Person> all() {
        var person = this.personRepository.findAll();
        return person;
    }
    @GetMapping("/count")
    public long count(){
        var counting = this.personRepository.count();
        return counting;
    }
    

    @PostMapping
    public Person save(@RequestBody Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        var user = new Person(person.getLogin(),person.getPassword(),person.getEmail(),person.getRole());

        // save note instance to db
        this.personRepository.save(user);

        return user;
    }

    @GetMapping("/login")
    public String login(){
        return "authenticated successfully";
    }

    
}
