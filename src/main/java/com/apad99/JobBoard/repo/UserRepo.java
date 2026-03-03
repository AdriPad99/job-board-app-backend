package com.apad99.JobBoard.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apad99.JobBoard.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
