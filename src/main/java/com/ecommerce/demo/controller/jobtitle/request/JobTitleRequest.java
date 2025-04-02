package com.ecommerce.demo.controller.jobtitle.request;

import com.ecommerce.demo.controller.jobtitle.dto.JobTitleNameHistoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobTitleRequest {
    private Integer jobTitleId;
    private String jobTitleCode;
    private List<JobTitleNameHistoryDto> lstJobTitleNameHistoryDto;
    private Integer groupJobId;
}
