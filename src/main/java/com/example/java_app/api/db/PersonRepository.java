package com.example.java_app.api.db;

import java.util.Optional;

import com.example.java_app.api.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>
{
    Optional<Person> findByUsername(String username);
}