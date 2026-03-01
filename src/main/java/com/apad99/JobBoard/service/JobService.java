package com.apad99.JobBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apad99.JobBoard.model.JobPost;
import com.apad99.JobBoard.repo.JobRepo;

@Service
public class JobService {
    
    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(Integer i) {
        return repo.getJob(i);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(Integer postId) {
        repo.deleteJob(postId);
    }

}
