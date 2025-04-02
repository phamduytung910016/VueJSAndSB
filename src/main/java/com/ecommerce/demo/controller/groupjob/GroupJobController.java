package com.ecommerce.demo.controller.groupjob;

import com.ecommerce.demo.controller.groupjob.dto.GroupJobDto;
import com.ecommerce.demo.controller.groupjob.request.GroupJobRequest;
import com.ecommerce.demo.controller.jobtitle.dto.JobTitleInforDto;
import com.ecommerce.demo.service.groupjob.GroupJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseStatus
@RequestMapping(path = "api/groupjob")
@CrossOrigin(origins = "http://localhost:5173")
public class GroupJobController {

    @Autowired
    private GroupJobService groupJobService;

    @PostMapping("findAll")
    public ResponseEntity<List<GroupJobDto>> findAll(){
        return ResponseEntity.ok(groupJobService.getAll());
    }

    @PostMapping("create")
    public ResponseEntity<String> createGJ(@RequestBody GroupJobRequest request) throws Exception {
        groupJobService.create(request);
        return ResponseEntity.ok("Susscess");
    }

    @PostMapping("findById")
    public ResponseEntity<GroupJobDto> findById(@RequestParam(name = "groupJobId") Integer groupJobId){
        return ResponseEntity.ok(groupJobService.getById(groupJobId));
    }

    @PostMapping("update")
    public ResponseEntity<String> updateGJ(@RequestBody GroupJobRequest request) throws Exception {
        groupJobService.update(request);
        return ResponseEntity.ok("Susscess");
    }

    @PostMapping("delete")
    public ResponseEntity<String> deleteGJ(@RequestParam(name = "groupJobId") int groupJobId) throws Exception {
        groupJobService.deleteById(groupJobId);
        return ResponseEntity.ok("Susscess");
    }
}
