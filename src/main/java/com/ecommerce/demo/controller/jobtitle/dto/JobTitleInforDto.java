package com.ecommerce.demo.controller.jobtitle.dto;

import com.ecommerce.demo.controller.groupjob.dto.GroupJobDto;
import com.ecommerce.demo.model.GroupJob;
import com.ecommerce.demo.model.JobTitle;
import com.ecommerce.demo.model.JobTitleNameHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobTitleInforDto {
    private Integer jobTitleId;
    private String jobTitleCode;
    private List<JobTitleNameHistoryDto> lstJobTitleNameHistoryDto;
    private GroupJobDto groupJobDto;

    public static JobTitleInforDto fromEntity(List<JobTitleNameHistory> jobTitleNameHistory,
                                              JobTitle jobTitle) {
        JobTitleInforDto jobTitleInforDto = new JobTitleInforDto();
        jobTitleInforDto.setJobTitleId(jobTitle.jobTitleId);
        jobTitleInforDto.setJobTitleCode(jobTitle.jobTitleCode);
        GroupJob groupJob = jobTitle.groupJob;
        jobTitleInforDto.setGroupJobDto(groupJob == null ? null : GroupJobDto.fromEntity(groupJob));
        jobTitleInforDto.setLstJobTitleNameHistoryDto(jobTitleNameHistory.stream().map(x -> JobTitleNameHistoryDto.fromEntity(x))
        .collect(Collectors.toList()));
        return jobTitleInforDto;
    }
}
