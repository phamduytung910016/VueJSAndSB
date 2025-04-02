package com.ecommerce.demo.service.groupjob.impl;

import com.ecommerce.demo.controller.groupjob.dto.GroupJobDto;
import com.ecommerce.demo.controller.groupjob.request.GroupJobRequest;
import com.ecommerce.demo.model.GroupJob;
import com.ecommerce.demo.repository.GroupJobRepo;
import com.ecommerce.demo.repository.JobTitleRepo;
import com.ecommerce.demo.service.groupjob.GroupJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupJobServiceImpl implements GroupJobService {

    @Autowired
    private GroupJobRepo groupJobRepo;

    @Autowired
    private JobTitleRepo jobTitleRepo;

    @Override
    public void create(GroupJobRequest request) throws Exception {
        if(groupJobRepo.findByGroupJobCode(request.getGroupJobCode()).size() > 0){
            throw new Exception("GroupJobCode has exists");
        }
        GroupJob groupJob = new GroupJob();
        groupJob.groupJobCode = request.getGroupJobCode();
        groupJob.groupJobName = request.getGroupJobName();
        groupJobRepo.save(groupJob);
    }

    @Override
    public void update(GroupJobRequest request) throws Exception {
        if(groupJobRepo.findByGroupJobCode(request.getGroupJobCode()).size() >= 2){
            throw new Exception("GroupJobCode has exists");
        }
        GroupJob groupJob = new GroupJob();
        groupJob.groupJobCode = request.getGroupJobCode();
        groupJob.groupJobName = request.getGroupJobName();
        groupJob.groupJobId = request.getGroupJobId();
        groupJobRepo.save(groupJob);
    }

    @Override
    public List<GroupJobDto> getAll() {
        return groupJobRepo.findAll().stream().map(x -> GroupJobDto.fromEntity(x)).collect(Collectors.toList());
    }

    @Override
    public GroupJobDto getById(Integer groupJobId) {
        Optional<GroupJob> opGroupJob = groupJobRepo.findById(groupJobId);
        return opGroupJob.isPresent() ? GroupJobDto.fromEntity(opGroupJob.get()) : null;
    }

    @Override
    public void deleteById(Integer groupJobId) throws Exception {
        if(jobTitleRepo.findByGroupJobGroupJobId(groupJobId).isPresent()){
            throw new Exception("GroupJob has been used");
        }
        groupJobRepo.deleteById(groupJobId);
    }
}
