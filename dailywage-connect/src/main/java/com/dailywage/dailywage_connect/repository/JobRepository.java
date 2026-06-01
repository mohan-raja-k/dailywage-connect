package com.dailywage.dailywage_connect.repository;

import com.dailywage.dailywage_connect.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobModel,Long> {
    @Query("select j from JobModel j where UPPER(j.jobLocation)= UPPER(:location)")
    List<JobModel> findjobByLocation(String location);
    @Query("select j from JobModel j where UPPER(j.jobStatus)= UPPER(:status)")
    List<JobModel> findjobByStatus(String status);
}
