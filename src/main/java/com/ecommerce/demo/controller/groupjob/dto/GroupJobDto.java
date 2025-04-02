package com.ecommerce.demo.controller.groupjob.dto;

import com.ecommerce.demo.model.GroupJob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupJobDto {
    private Integer groupJobId;
    private String groupJobCode;
    private String groupJobName;

    public static GroupJobDto fromEntity(GroupJob groupJob){
        return new GroupJobDto(groupJob.groupJobId, groupJob.groupJobCode, groupJob.groupJobName);
    }
}
