package com.ecommerce.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group_job")
@AllArgsConstructor
@NoArgsConstructor
public class GroupJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_job_id")
    public Integer groupJobId;

    @Column(nullable = false, unique = true)
    public String groupJobCode;

    @Column(nullable = false, unique = true)
    public String groupJobName;
}
