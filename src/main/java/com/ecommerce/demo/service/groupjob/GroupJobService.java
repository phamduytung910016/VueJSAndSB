package com.ecommerce.demo.service.groupjob;

import com.ecommerce.demo.controller.groupjob.dto.GroupJobDto;
import com.ecommerce.demo.controller.groupjob.request.GroupJobRequest;

import java.util.List;

public interface GroupJobService {
    /**
     * create groupJob
     * @param request
     */
    void create(GroupJobRequest request) throws Exception;

    /**
     * update groupJob
     * @param request
     */
    void update(GroupJobRequest request) throws Exception;

    /**
     * get all
     * @return
     */
    List<GroupJobDto> getAll();

    /**
     * find by id
     * @param groupJobId
     * @return
     */
    GroupJobDto getById(Integer groupJobId);

    /**
     * delete by id
     * @param groupJobId
     */
    void deleteById(Integer groupJobId) throws Exception;
}
