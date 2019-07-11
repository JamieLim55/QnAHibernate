package com.example.qahibernate.repositories;
import com.example.qahibernate.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<Users, Long>{

    
}