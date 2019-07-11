package com.example.qahibernate.controllers;
import java.util.List;
import com.example.qahibernate.entities.Answers;
import com.example.qahibernate.entities.Questions;
import com.example.qahibernate.repositories.AnswerRepository;
import com.example.qahibernate.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnswerController
 */

@RestController
@RequestMapping(path = "/api")
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping(value = "/questions/{id}/answers")
    public void addAnswerForQuestion(@RequestBody Answers answer, @PathVariable("id") long questionId) {
        Questions question = questionRepository.findById(questionId).orElse(new Questions());

        if(question.getId() != null){
            answer.setQuestionId(questionId);
            answerRepository.save(answer);
        }
    }

    @PostMapping(value="/answers/{id}")
    public void updateAnswerText(@RequestBody Answers answer, @PathVariable("id") long id){
        Answers existingAnswer = answerRepository.findById(id).orElse(new Answers());
        if(existingAnswer.getId() != null){
            answer.setId(id);
            answerRepository.save(answer);
        };
    }
    
    @GetMapping(value="/questions/{id}/answers" , produces="application/json")
    public List<Answers> displayAnswerByQuestionId(@PathVariable long id) {
        return answerRepository.findAllByQuestionId(id); 
             
    }
}