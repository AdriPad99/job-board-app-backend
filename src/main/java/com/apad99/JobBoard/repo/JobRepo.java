package com.apad99.JobBoard.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apad99.JobBoard.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{

    @Query(value = """
            SELECT * FROM job_post
            WHERE post_profile ILIKE CONCAT('%', :keyword, '%')
               OR post_desc ILIKE CONCAT('%', :keyword, '%')
               OR EXISTS (
                   SELECT 1 FROM unnest(post_tech_stack) AS skill
                   WHERE skill ILIKE CONCAT('%', :keyword, '%')
               )
            """, nativeQuery = true)
    List<JobPost> findByKeyword(@Param("keyword") String keyword);

}