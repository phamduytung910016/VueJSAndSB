package com.ecommerce.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "job_title")
@AllArgsConstructor
@NoArgsConstructor
public class JobTitle {

    @Id
    @Column(name = "job_title_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer jobTitleId;

    @Column(name = "job_title_code", nullable = false, unique = true)
    public String jobTitleCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_job_id", nullable = true)
    public GroupJob groupJob;

}
