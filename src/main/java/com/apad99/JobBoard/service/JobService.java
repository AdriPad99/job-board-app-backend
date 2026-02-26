package com.apad99.JobBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apad99.JobBoard.model.JobPost;
import com.apad99.JobBoard.repo.JobRepo;

@Service
public class JobService {
    
    @Autowired
    private JobRepo service;

    public void addJob(JobPost jobPost) {
        service.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    public JobPost getJob(Integer i) {
        return service.getJob(i);
    }

}
