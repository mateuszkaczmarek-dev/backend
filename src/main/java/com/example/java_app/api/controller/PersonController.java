package com.example.java_app.api.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

//import com.example.java_app.Mapper;
import com.example.java_app.api.db.PersonRepository;
import com.example.java_app.api.db.QuestionRepository;
import com.example.java_app.api.model.Person;
import com.example.java_app.api.model.Questions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.example.java_app.api.viewmodel.PersonViewModel;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("api")
@RestController
@CrossOrigin(origins = "*")
public class PersonController {

    
    private PersonRepository personRepository;
    private QuestionRepository questionRepository;
    public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    public PersonController(PersonRepository personRepository,QuestionRepository questionRepository) {
        this.personRepository = personRepository;
        this.questionRepository = questionRepository;
    }

    @RequestMapping(value = "/all" , method = RequestMethod.GET)
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
        if(personRepository.findByUsername(person.getUsername()) != null){
        logger.info("error user exist " + person);
        }
        var user = new Person(person.getUsername(),person.getPassword(),person.getEmail(),"ROLE_USER");
        // save note instance to db
        this.personRepository.save(user);

        return user;
    }

    @RequestMapping(value = "/allquestions" , method = RequestMethod.GET)
    public List<Questions> allQuestions() {
        var question = this.questionRepository.findAll();
        return question;
    }

    @PostMapping("/questions")
    public Questions saveQuestion(@RequestBody Questions question, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        var _question = new Questions(question.getQuestion());
        // save note instance to db
        this.questionRepository.save(_question);

        return _question;
    }


    @RequestMapping("/users")
    public Principal person(HttpServletRequest request){
        String authToken = request.getHeader("Authorization")
        .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
        
    }

    
}
