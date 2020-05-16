package com.example.java_app.api.db;


import com.example.java_app.api.model.Person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "api.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {
    private PersonRepository personRepository;

    public DbSeeder(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public void run(String... args) {
        // Remove all existing entities
        this.personRepository.deleteAll();

        // Save the welcome note
        //var person = new Person("root","root","root@gmail.com","ROLE_ADMIN");
        var person2 = new Person("user","user","user@gmail.com","ROLE_USER");
       // this.personRepository.save(person);
        this.personRepository.save(person2);
        System.out.println("Initialized database");
    }
}