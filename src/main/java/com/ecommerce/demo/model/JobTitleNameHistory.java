package com.ecommerce.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "job_title_name_history")
@AllArgsConstructor
@NoArgsConstructor
public class JobTitleNameHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer jobTitleHistoryId;

    @Column(name = "job_title_name", nullable = false)
    public String jobTitleName;

    @Column(nullable = false)
    public Date startDate;

    @Column(nullable = false)
    public Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_title_id", nullable = false, referencedColumnName = "job_title_id")
    public JobTitle jobTitle;

}
