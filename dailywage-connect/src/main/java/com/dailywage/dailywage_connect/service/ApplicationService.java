package com.dailywage.dailywage_connect.service;

import com.dailywage.dailywage_connect.model.ApplicationModel;
import com.dailywage.dailywage_connect.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationRepository ar;
    public ApplicationModel addApplicaion(ApplicationModel am)
    {
        return ar.save(am);
    }
    public List<ApplicationModel> getAllAppliction()
    {
        return ar.findAll();
    }
    public String deleteApplication(Long id)
    {
        ar.deleteById(id);
        return "deleted";
    }
    public ApplicationModel update(ApplicationModel newvalue,Long id)
    {
        ApplicationModel olddata=ar.findById(id).orElse(null);
        olddata.setApplicationDate(newvalue.getApplicationDate());
        olddata.setApplicationStatus(newvalue.getApplicationStatus());
        olddata.setJobId(newvalue.getJobId());
        olddata.setUserId(newvalue.getUserId());
        return ar.save(olddata);

    }
    public List<ApplicationModel> findApplicationByUserId(Long id)
    {
        return ar.findByUserId(id);
    }
    public List<ApplicationModel> findApplicationByJobId(Long id)
    {
        return ar.findByJobId(id);
    }



}
