package com.ecommerce.demo.repository;

import com.ecommerce.demo.model.GroupJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupJobRepo extends JpaRepository<GroupJob,Integer> {
    List<GroupJob> findByGroupJobCode(String groupJobCode);
}
