package com.ecommerce.demo.repository;

import com.ecommerce.demo.model.GroupJob;
import com.ecommerce.demo.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobTitleRepo extends JpaRepository<JobTitle, Integer> {
    Optional<JobTitle> findByJobTitleCode(String jobTitleCode);

    Optional<JobTitle> findByGroupJobGroupJobId(Integer groupJobId);
}
