package com.ecommerce.demo.service.jobtitle;

import com.ecommerce.demo.controller.jobtitle.dto.JobTitleInforDto;
import com.ecommerce.demo.controller.jobtitle.request.JobTitleRequest;

import java.util.List;

public interface JobTitleService {
    /**
     * get all
     * @return
     */
    List<JobTitleInforDto> getAll();

    /**
     * get by id
     * @param jobTitleId
     * @return
     */
    JobTitleInforDto getById(Integer jobTitleId);

    /**
     * create
     * @param request
     */
    void create(JobTitleRequest request) throws Exception;

    /**
     * update
     * @param request
     */
    void update(JobTitleRequest request) throws Exception;
}
