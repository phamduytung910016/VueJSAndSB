package com.ecommerce.demo.controller.groupjob.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupJobRequest {
    private Integer groupJobId;
    private String groupJobCode;
    private String groupJobName;
}
