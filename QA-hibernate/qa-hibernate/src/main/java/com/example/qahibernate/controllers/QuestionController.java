package com.example.qahibernate.controllers;
import java.util.List;
import com.example.qahibernate.entities.Questions;
import com.example.qahibernate.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuestionController
 */
@RestController
@RequestMapping(path="/api")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping(value="/questions")
    public Questions createUser(@RequestBody Questions question) {
        questionRepository.save(question);
        return question;
    }

    @GetMapping(value="/questions" , produces="application/json")
    public List<Questions> displayQuestions(
        @RequestParam(required=false) String description) {
            List <Questions> question = questionRepository.findAllByDescriptionContaining(description);
            if(question.size()>=1){
            return question;
            }
            return questionRepository.findAll();
            
        }

}