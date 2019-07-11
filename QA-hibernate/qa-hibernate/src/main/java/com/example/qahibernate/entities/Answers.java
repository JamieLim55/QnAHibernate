package com.example.qahibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Answers
 */
@Entity(name="answers")
public class Answers {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;
    
    @Column(name = "question_id")
    private long questionId;

    @Column(name = "user_id")
    private long userId;
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



    
}