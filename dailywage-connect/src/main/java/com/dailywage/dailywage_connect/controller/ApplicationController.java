package com.dailywage.dailywage_connect.controller;

import com.dailywage.dailywage_connect.model.ApplicationModel;
import com.dailywage.dailywage_connect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Application")
public class ApplicationController {
      @Autowired
    ApplicationService as;
      @PostMapping("/addApplication")
      public ApplicationModel addApplication(@RequestBody ApplicationModel am)
      {
          return as.addApplicaion(am);
      }
      @GetMapping("/getApplication")
      public List<ApplicationModel> getAllApplication()
      {
          return as.getAllAppliction();
      }
      @DeleteMapping("/deleteApplication/{id}")
      public String deleteApplication(@PathVariable Long id)
      {
          return as.deleteApplication(id);

      }
      @PutMapping("/updateApplication/{id}")
      public ApplicationModel updateApplication(@RequestBody ApplicationModel am,@PathVariable Long id)
      {
          return as.update(am,id);
      }
      @GetMapping("/findApplicationByUserId")
      public List<ApplicationModel> findApplicationByUserId(@RequestParam("userid") Long id)
      {
          return as.findApplicationByUserId(id);
      }
      @GetMapping("/findApplicationByJobId")
      public List<ApplicationModel> findApplicationByJobId(@RequestParam("jobid") Long id)
      {
          return as.findApplicationByJobId(id);
      }

}
