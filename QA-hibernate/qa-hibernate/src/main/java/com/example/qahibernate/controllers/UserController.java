package com.example.qahibernate.controllers;

import java.util.List;

import com.example.qahibernate.entities.Answers;
import com.example.qahibernate.entities.Questions;
import com.example.qahibernate.entities.Users;
import com.example.qahibernate.repositories.AnswerRepository;
import com.example.qahibernate.repositories.QuestionRepository;
import com.example.qahibernate.repositories.UserRepository;
import com.example.qahibernate.response_formats.QAShowJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @PostMapping(value="/users")
    public Users createUser(@RequestBody Users user) {
        userRepository.save(user);
        return user;
    }

    @DeleteMapping(value="/users/{id}")
    public void deleteUser(@PathVariable("id") long id){
        Users existingUser = userRepository.findById(id).orElse(new Users());
        if(existingUser.getId() != null){
            List<Answers>  answer =  answerRepository.findByUserId(existingUser.getId());
            answerRepository.deleteAll(answer);

            List<Questions>  question =  questionRepository.findByUserId(existingUser.getId());
            questionRepository.deleteAll(question);

            userRepository.delete(existingUser);
        }
    }

    @GetMapping(value="/users/{id}/submissions" , produces="application/json")
    public QAShowJson displayQA(@PathVariable long id) {
        QAShowJson json = new QAShowJson();

        List<Questions> listQuestions = questionRepository.findByUserId(id);
        List<Answers> listAnswers = answerRepository.findByUserId(id);
       
        
        json.setListQuestions(listQuestions);
        json.setListAnswers(listAnswers);

        return json;
    }
    
}