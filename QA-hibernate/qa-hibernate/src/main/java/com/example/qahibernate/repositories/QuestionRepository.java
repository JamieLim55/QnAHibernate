package com.example.qahibernate.repositories;

import java.util.List;

import com.example.qahibernate.entities.Questions;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * QuestionRepository
 */
public interface QuestionRepository extends JpaRepository<Questions, Long>{

    List<Questions> findByUserId(Long userId);
    List<Questions> findAllByDescriptionContaining(String description);

    
    // List<Questions> findDistinctDescriptionByUserId(Long userId);
     
}