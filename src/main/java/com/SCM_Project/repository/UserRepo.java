package com.SCM_Project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SCM_Project.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

   Optional<User> findByEmail(String email);
}
