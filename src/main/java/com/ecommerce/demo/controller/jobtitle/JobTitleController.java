package com.ecommerce.demo.controller.jobtitle;

import com.ecommerce.demo.controller.jobtitle.dto.JobTitleInforDto;
import com.ecommerce.demo.controller.jobtitle.request.JobTitleRequest;
import com.ecommerce.demo.service.jobtitle.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/jobTitle")
@ResponseStatus
@CrossOrigin(origins = "http://localhost:5173")
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @PostMapping("/findAll")
    public ResponseEntity<List<JobTitleInforDto>> getAll(){
        return ResponseEntity.ok(jobTitleService.getAll());
    }

    @PostMapping("/findById")
    public ResponseEntity<JobTitleInforDto> findById(@RequestParam(name = "jobTitleId") Integer jobTitleId){
        return ResponseEntity.ok(jobTitleService.getById(jobTitleId));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createJobTitle(@RequestBody JobTitleRequest request) throws Exception {
        jobTitleService.create(request);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateJobTitle(@RequestBody JobTitleRequest request) throws Exception {
        jobTitleService.update(request);
        return ResponseEntity.ok("Success");
    }
}
