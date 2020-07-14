package com.example.java_app.api.db;

import com.example.java_app.api.model.SecondQuestions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondQuestionRepository extends JpaRepository<SecondQuestions,Long> {
    
}