package com.dailywage.dailywage_connect.repository;

import com.dailywage.dailywage_connect.model.ApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationModel,Long> {

    @Query("Select a from ApplicationModel a where a.userId =:userId")
    List<ApplicationModel> findByUserId(Long userId);

    @Query("Select a from ApplicationModel a where a.jobId =:jobId")
    List<ApplicationModel> findByJobId(Long jobId);
}
