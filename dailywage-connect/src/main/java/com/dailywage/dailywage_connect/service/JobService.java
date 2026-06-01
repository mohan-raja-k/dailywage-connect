package com.dailywage.dailywage_connect.service;

import com.dailywage.dailywage_connect.model.JobModel;
import com.dailywage.dailywage_connect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository jr;
    public JobModel addJob(JobModel jm)
    {
        return jr.save(jm);
    }
    public List<JobModel> getAllJob()
    {
        return jr.findAll();
    }
    public String deleteJob(Long id)
    {
        jr.deleteById(id);
        return "deleted";
    }
    public JobModel updateJob(JobModel newvalue,Long id)
    {
        JobModel olddata=jr.findById(id).orElse(null);
        olddata.setJobDate(newvalue.getJobDate());
        olddata.setJobDescription(newvalue.getJobDescription());
        olddata.setJobLocation(newvalue.getJobLocation());
        olddata.setJobPayPerDay(newvalue.getJobPayPerDay());
        olddata.setJobStatus(newvalue.getJobStatus());
        olddata.setJobSkillRequired(newvalue.getJobSkillRequired());
        olddata.setJobTitle(newvalue.getJobTitle());
        return jr.save(olddata);

    }
    public List<JobModel> getJobByLocation(String location)
    {
        return jr.findjobByLocation(location);
    }
    public List<JobModel> getJobByStatus(String status)
    {
        return jr.findjobByStatus(status);
    }

}
