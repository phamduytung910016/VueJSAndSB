package com.ecommerce.demo.controller.jobtitle.dto;

import com.ecommerce.demo.common.DateHandler;
import com.ecommerce.demo.model.JobTitleNameHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobTitleNameHistoryDto {
    private String jobTitleName;
    private Integer jobTitleHistoryId;
    private String startDate;
    private String endDate;

    public static JobTitleNameHistoryDto fromEntity(JobTitleNameHistory jobTitleNameHistory) {
        return new JobTitleNameHistoryDto(jobTitleNameHistory.jobTitleName, jobTitleNameHistory.jobTitleHistoryId,
                DateHandler.fromDateToString(jobTitleNameHistory.startDate),
                DateHandler.fromDateToString(jobTitleNameHistory.endDate));
    }
}
