package com.apad99.JobBoard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apad99.JobBoard.model.User;
import com.apad99.JobBoard.model.UserPrincipal;
import com.apad99.JobBoard.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        // grabs user from db by their username
        User user = repo.findByUsername(username);
    
        // edgecase where user doesn't exist in db
        if(user == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }
    
        // return out user if found in db
        return new UserPrincipal(user);
    }
}