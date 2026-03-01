package com.apad99.JobBoard.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.apad99.JobBoard.model.JobPost;

@Repository
public class JobRepo {
    
    List<JobPost> jobPosts = new ArrayList<>(Arrays.asList(
        new JobPost(1, "Backend Developer", "Build and maintain REST APIs", 2, List.of("Java", "Spring Boot", "PostgreSQL")),
        new JobPost(2, "Frontend Developer", "Develop responsive UI components", 1, List.of("React", "JavaScript", "CSS")),
        new JobPost(3, "Full Stack Developer", "Work across the entire tech stack", 3, List.of("Java", "React", "Docker", "AWS")),
        new JobPost(4, "DevOps Engineer", "Manage CI/CD pipelines and infrastructure", 4, List.of("Docker", "Kubernetes", "Jenkins", "AWS")),
        new JobPost(5, "Data Engineer", "Design and maintain data pipelines", 2, List.of("Python", "SQL", "Spark", "Kafka"))
    ));

    public List<JobPost> getAllJobs() {
        return jobPosts;
    }

    public void addJob(JobPost job) {
        jobPosts.add(job);
        System.out.println(job);
    }

    public JobPost getJob(Integer postId) {

        for (JobPost job: jobPosts) {
            if (job.getPostId() == postId) {
                return job;
            }
        }

        return null;
    }

    public void updateJob(JobPost jobPost) {
        for (JobPost jobPost1 : jobPosts) {
            if (jobPost1.getPostId() == jobPost.getPostId()) {
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJob(Integer postId) {
        jobPosts.removeIf(jobPost -> jobPost.getPostId() == postId);
    }
}
