package com.example.qahibernate.repositories;

import java.util.List;
import com.example.qahibernate.entities.Answers;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * AnswerRepository
 */
public interface AnswerRepository extends JpaRepository<Answers, Long>{
    List<Answers> findByQuestionId(long questionId);

	List<Answers> findByUserId(long userId);

    List<Answers> findAllByQuestionId(long questionId);
    
    // @Query("SELECT p.text FROM Answers p WHERE p.user_id= ?1")
    // List<Answers> findListAnswersForUser(long userId);
    
}