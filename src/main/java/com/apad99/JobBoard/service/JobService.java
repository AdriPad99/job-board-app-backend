package com.apad99.JobBoard.service;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apad99.JobBoard.model.JobPost;
import com.apad99.JobBoard.repo.JobRepo;

import jakarta.annotation.PostConstruct;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(Integer i) {
        return repo.findById(i).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(Integer postId) {
        repo.deleteById(postId);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByKeyword(keyword);
    }

    @PostConstruct
    public void load() {
        List<JobPost> jobPosts = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Backend Developer", "Build and maintain REST APIs", 2,
                        List.of("Java", "Spring Boot", "PostgreSQL")),
                new JobPost(2, "Frontend Developer", "Develop responsive UI components", 1,
                        List.of("React", "JavaScript", "CSS")),
                new JobPost(3, "Full Stack Developer", "Work across the entire tech stack",
                        3, List.of("Java", "React", "Docker", "AWS")),
                new JobPost(4, "DevOps Engineer", "Manage CI/CD pipelines andinfrastructure", 4,
                        List.of("Docker", "Kubernetes", "Jenkins", "AWS")),
                new JobPost(5, "Data Engineer", "Design and maintain data pipelines", 2,
                        List.of("Python", "SQL", "Spark", "Kafka"))));

        repo.saveAll(jobPosts);
    }

}
