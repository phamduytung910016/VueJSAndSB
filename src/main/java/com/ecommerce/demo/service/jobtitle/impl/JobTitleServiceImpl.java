package com.ecommerce.demo.service.jobtitle.impl;

import com.ecommerce.demo.common.DateHandler;
import com.ecommerce.demo.controller.jobtitle.dto.JobTitleInforDto;
import com.ecommerce.demo.controller.jobtitle.dto.JobTitleNameHistoryDto;
import com.ecommerce.demo.controller.jobtitle.request.JobTitleRequest;
import com.ecommerce.demo.model.GroupJob;
import com.ecommerce.demo.model.JobTitle;
import com.ecommerce.demo.model.JobTitleNameHistory;
import com.ecommerce.demo.repository.GroupJobRepo;
import com.ecommerce.demo.repository.JobTitleNameHistoryRepo;
import com.ecommerce.demo.repository.JobTitleRepo;
import com.ecommerce.demo.service.jobtitle.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    @Autowired
    private JobTitleRepo jobTitleRepo;

    @Autowired
    private JobTitleNameHistoryRepo jobTitleNameHistoryRepo;

    @Autowired
    private GroupJobRepo groupJobRepo;


    @Override
    public List<JobTitleInforDto> getAll() {
        List<JobTitle> lstJobTitle = jobTitleRepo.findAll();
        List<JobTitleNameHistory> lstJobTitleNameHistory = jobTitleNameHistoryRepo.findAll();
        Map<Integer, List<JobTitleNameHistory>> mapJTIdToLstJTNameHistory = lstJobTitleNameHistory
                .stream().collect(Collectors.groupingBy(x -> x.jobTitle.jobTitleId));
        List<JobTitleInforDto> rs = lstJobTitle.stream().map(x ->
                JobTitleInforDto.fromEntity(
                        mapJTIdToLstJTNameHistory.get(x.jobTitleId).stream().sorted((a,b) -> a.startDate.compareTo(b.startDate)).collect(Collectors.toList()),
                        x)).collect(Collectors.toList());
        return rs;
    }

    @Override
    public JobTitleInforDto getById(Integer jobTitleId) {
        Optional<JobTitle> opJobTitle = jobTitleRepo.findById(jobTitleId);
        if (opJobTitle.isPresent()) {
            List<JobTitleNameHistory> lstJTNameHistory = jobTitleNameHistoryRepo.findByJobTitleJobTitleId(opJobTitle.get().jobTitleId);
            JobTitleInforDto.fromEntity(lstJTNameHistory, opJobTitle.get());
        }
        return null;
    }

    @Override
    public void create(JobTitleRequest request) throws Exception {
        if (jobTitleRepo.findByJobTitleCode(request.getJobTitleCode()).isPresent()) {
            throw new Exception("JobTitleCode is exits");
        }
        JobTitle jobTitle = new JobTitle();
        jobTitle.jobTitleCode = request.getJobTitleCode();
        if(request.getGroupJobId() != null) {
            Optional<GroupJob> groupJob = groupJobRepo.findById(request.getGroupJobId());
            jobTitle.groupJob = groupJob.orElse(null);
        }
        List<JobTitleNameHistory> lstJobTitleNameHistory = request.getLstJobTitleNameHistoryDto()
                .stream().map(x -> {
                    JobTitleNameHistory jobTitleNameHistory = new JobTitleNameHistory();
                    jobTitleNameHistory.jobTitleName = x.getJobTitleName();
                    jobTitleNameHistory.startDate = DateHandler.fromStringToDate(x.getStartDate());
                    jobTitleNameHistory.endDate = DateHandler.fromStringToDate(x.getEndDate());
                    jobTitleNameHistory.jobTitle = jobTitle;
                    return jobTitleNameHistory;
                }).collect(Collectors.toList());
        jobTitleRepo.save(jobTitle);
        jobTitleNameHistoryRepo.saveAll(lstJobTitleNameHistory);
    }

    @Override
    public void update(JobTitleRequest request) throws Exception {
        if (jobTitleRepo.findByJobTitleCode(request.getJobTitleCode()).isPresent()) {
            throw new Exception("JobTitleCode is exits");
        }
        if(jobTitleRepo.findById(request.getJobTitleId()).isPresent()){
            JobTitle jt = jobTitleRepo.findById(request.getJobTitleId()).get();
            jt.jobTitleCode = request.getJobTitleCode();
            GroupJob gj = groupJobRepo.findById(request.getGroupJobId()).orElse(null);
            jt.groupJob = gj;
            List<JobTitleNameHistory> lstJTNHnew = new ArrayList<>();
            List<JobTitleNameHistory> lstJTNHupdate = new ArrayList<>();
            request.getLstJobTitleNameHistoryDto().stream().forEach(x -> {
                JobTitleNameHistory jTNameHistory = new JobTitleNameHistory();
                jTNameHistory.jobTitleHistoryId = x.getJobTitleHistoryId();
                jTNameHistory.jobTitleName = x.getJobTitleName();
                jTNameHistory.startDate = DateHandler.fromStringToDate(x.getStartDate());
                jTNameHistory.endDate = DateHandler.fromStringToDate(x.getEndDate());
                jTNameHistory.jobTitle = jt;
                if (jTNameHistory.jobTitleHistoryId == null) {
                    lstJTNHnew.add(jTNameHistory);
                } else {
                    lstJTNHupdate.add(jTNameHistory);
                }
            });
            List<JobTitleNameHistory> lstJTNHOld = jobTitleNameHistoryRepo.findByJobTitleJobTitleId(jt.jobTitleId);
            List<JobTitleNameHistory> lstJTNHDelete = lstJTNHOld.stream().filter(x -> !lstJTNHupdate.contains(x))
                            .collect(Collectors.toList());
            jobTitleRepo.save(jt);
            jobTitleNameHistoryRepo.deleteAll(lstJTNHDelete);
            jobTitleNameHistoryRepo.saveAll(lstJTNHupdate);
            jobTitleNameHistoryRepo.saveAll(lstJTNHnew);
        }
    }

}
