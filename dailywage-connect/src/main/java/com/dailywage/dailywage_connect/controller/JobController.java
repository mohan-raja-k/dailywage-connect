package com.dailywage.dailywage_connect.controller;

import com.dailywage.dailywage_connect.model.JobModel;
import com.dailywage.dailywage_connect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Job")
@RestController

public class JobController {
    @Autowired
    JobService js;
    @PostMapping("/addJob")
    public JobModel addJob(@RequestBody JobModel jm)
    {
        return js.addJob(jm);
    }
    @GetMapping("/getJob")
    public List<JobModel> getAllJob()
    {

        return js.getAllJob();
    }
    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable Long id)
    {
        return js.deleteJob(id);
    }
    @PutMapping("/updateJob/{id}")
    public JobModel updateJob(@RequestBody JobModel jm,@PathVariable Long id)
    {
        return js.updateJob(jm,id);
    }
    @GetMapping("/getJobByLocation")
    public List<JobModel> getJobByLocation(@RequestParam("location") String location)
    {
        return js.getJobByLocation(location);
    }
    @GetMapping("/getJobByStatus")
    public List<JobModel> getJobByStatus(@RequestParam("status") String status)
    {
        return js.getJobByStatus(status);
    }
}
