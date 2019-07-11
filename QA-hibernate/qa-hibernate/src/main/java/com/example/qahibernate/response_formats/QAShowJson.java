package com.example.qahibernate.response_formats;

import java.util.List;

import com.example.qahibernate.entities.Answers;
import com.example.qahibernate.entities.Questions;


/**
 * QAShowJson
 */
public class QAShowJson {

       
    public List<Questions> listQuestions;

    public List<Answers> listAnswers;



    public List<Questions> getListQuestions() {
        return this.listQuestions;
    }

    public void setListQuestions(List<Questions> listQuestions) {
        this.listQuestions = listQuestions;
    }

    public List<Answers> getListAnswers() {
        return this.listAnswers;
    }

    public void setListAnswers(List<Answers> listAnswers) {
        this.listAnswers = listAnswers;
    }
   
	
	


}