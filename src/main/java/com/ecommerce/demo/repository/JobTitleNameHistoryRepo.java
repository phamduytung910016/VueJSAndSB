package com.ecommerce.demo.repository;

import com.ecommerce.demo.controller.jobtitle.dto.JobTitleNameHistoryDto;
import com.ecommerce.demo.model.JobTitleNameHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobTitleNameHistoryRepo extends JpaRepository<JobTitleNameHistory, Integer> {
    List<JobTitleNameHistory> findByJobTitleJobTitleId(Integer jobTitleId);
}
