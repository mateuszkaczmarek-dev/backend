/*package com.example.java_app;
import com.example.java_app.api.db.PersonRepository;
import com.example.java_app.api.model.Person;
import com.example.java_app.api.viewmodel.PersonViewModel;


import org.springframework.stereotype.Component;

/*@Component
public class Mapper {
    
    private PersonRepository personRepository;

    public Mapper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonViewModel convertToPersonViewModel(Person entity) {
        var personModel = new PersonViewModel();
        personModel.setId(entity.getId());
        personModel.setLogin(entity.getLogin());
        personModel.setPassword(entity.getPassword());
        personModel.setEmail(entity.getEmail());
        return personModel;
    }

    public Person convertToPersonEntity(PersonViewModel viewModel) {
        var entity = new Person(viewModel.getLogin(), viewModel.getPassword(), viewModel.getEmail());

        return entity;
    }

    
}*/